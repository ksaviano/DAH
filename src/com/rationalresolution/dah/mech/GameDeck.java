package com.rationalresolution.dah.mech;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.apache.derby.impl.sql.catalog.SYSROUTINEPERMSRowFactory;

import com.rationalresolution.dah.cards.BlackCard;
import com.rationalresolution.dah.cards.CardCombos;
import com.rationalresolution.dah.cards.WhiteCard;

public class GameDeck {
	//	Fields
	private static int totalRounds = 0;												//	set this number to total number of rounds (usually 10)
	public static int WCCOUNT = 0;			//	5 players (4 ghosts + 1 real) with init 7 + 11 draws = 90
	public static int BCCOUNT = 0;								//	10 rounds in standard game
	private BlackCard currentBC;
	private WhiteCard roundWinner;
	
	public EntityManagerFactory emf;
	public EntityManager em;
	public static final WhiteCard notCard = new WhiteCard();
	
	private LinkedHashSet<WhiteCard> whitedeck = new LinkedHashSet(WCCOUNT); 
	private LinkedHashSet<BlackCard> blackdeck = new LinkedHashSet(BCCOUNT);
	private ArrayList<CardCombos> refcc	   	   = new ArrayList<>();
	private int roundnum = 1;					
	
	//	Constructor
	public GameDeck() {
		try {
			emf = Persistence.createEntityManagerFactory("DAH");
			em = emf.createEntityManager();
			
			WCCOUNT = (((totalRounds+1) * 5) + (7 * 5));
			BCCOUNT = (totalRounds+1);	
			System.out.println("In Game Deck Constructor");
			WhiteCard tempWC;
			int i = 0;
			System.out.println("GameDeck Construtor: totalRounds = " + totalRounds + "\tWCCOUNT = " + WCCOUNT + "\tcBCCOUNT = " + BCCOUNT);
			while(i < WCCOUNT) {
				tempWC = randoWCPicks();
				System.out.print(i + " " + tempWC + "\t");
					if(whitedeck.add(tempWC)) { 
						i++; 
					}
			}

			BlackCard tempBC;
			i = 0;
			while(i < BCCOUNT) {
				tempBC = randoBCPicks();
					if(blackdeck.add(tempBC)) { 
/*	REMOVE v1.0 */			System.out.println("\nDEBUG! In GameDeck - constructing blackdeck. int = " + i + " blackcard = " + tempBC.toString());						
						i++;
					}
			}
			
			setRefcombos();
		}
		catch(Exception e) {
			System.out.println("Error in Game Deck\n" + e);
			System.exit(0);
		}
	}
	
	//	Accessor Methods
	public int getRoundnum() 						{ return roundnum;		}
	public void setRoundnum()						{ roundnum++;			}
	public static void setTotalRounds(int r)		{ totalRounds = r;		}
	public static int getTotalRounds()				{ return totalRounds;	}
	public LinkedHashSet<WhiteCard> getWhitedeck()	{ return whitedeck;		}
	public WhiteCard getWhiteCard() {
		WhiteCard temp = null;
		Iterator<WhiteCard> wi = whitedeck.iterator();
		if(wi.hasNext()) {
			temp = wi.next();
			wi.remove();
		}
		return temp;
	}
	public BlackCard getBlackCard()	{				//	this function draws AND REMOVES the next black card from the black card deck
		Iterator<BlackCard> bi = blackdeck.iterator();
		if(bi.hasNext()) {
			currentBC = bi.next();
			/*	REMOVE v1.0 */			System.out.println("\nDEBUG! In GameDeck - constructing blackdeck. in getBlackCard " + currentBC.toString());						
			bi.remove();			
		}
		return currentBC;
	}
	
	public BlackCard dispCurrentBC() {				//	this function returns the card that is the current BC (no draw/removal from black card deck
		return currentBC;
	}
	
	public WhiteCard getRoundWinner()			{ return roundWinner;	}
	public void setRoundWinner(WhiteCard wc)	{ roundWinner = wc;		}
	
	
	
	private void setRefcombos() {
		CardCombos temp = new CardCombos();
		String qString = "SELECT c FROM CardCombos c WHERE c.ccbcFKey = :bcKey AND c.ccwcFKey = :wcKey";
/*	REMOVE v1.0 */			System.out.println("DEBUG! In GameDeck.setRefcombos()");					
		Iterator<BlackCard> bi = blackdeck.iterator();
		while(bi.hasNext()) {
			Iterator<WhiteCard> wi = whitedeck.iterator();
/*  REMOVE v1.0 */			System.out.println("DEBUG! Why isn't it doing the next black card: " + bi.hasNext() + " " + bi.toString());
			BlackCard btemp = bi.next();
			int bc = btemp.getCardID();
			while(wi.hasNext()) {
				WhiteCard wtemp = wi.next();
				int wc = wtemp.getcardID();	
/*	REMOVE v1.0 */			System.out.println("DEBUG! About to goto DB looking for " + bc + " with " + wc);
				Query query = em.createQuery(qString).setParameter("bcKey", bc).setParameter("wcKey", wc);
				List<CardCombos> elementlist = query.getResultList();
/*	REMOVE v1.0 */			System.out.println("DEBUG! Return from DB with " + elementlist.toString());
				if(!elementlist.isEmpty()) {
					refcc.add(elementlist.get(0));
				}
			}
		}
	}
	public ArrayList<CardCombos> getRefcombos()		{ return refcc;	}
	
	//	Methods
	private WhiteCard randoWCPicks() {
		WhiteCard temp = new WhiteCard();
		int rando = (int) (Math.random() * 300)+1;							
		String qString = "SELECT w FROM WhiteCard w WHERE w.cardID = :key";
		Query query = em.createQuery(qString).setParameter("key", rando);
		List<WhiteCard> elementList = query.getResultList();
		temp = elementList.get(0);
		return temp;	
	}
	
	private BlackCard randoBCPicks() {
		BlackCard temp = new BlackCard();
		int rando = (int) (Math.random() * 200)+1;							
		String qString = "SELECT b FROM BlackCard b WHERE b.cardID = :key";
		Query query = em.createQuery(qString).setParameter("key", rando);
		List<BlackCard> elementList = query.getResultList();
		temp = elementList.get(0);
		return temp;
	}
	
}
