package com.rationalresolution.dah.mech;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.rationalresolution.dah.cards.BlackCard;
import com.rationalresolution.dah.cards.CardCombos;
import com.rationalresolution.dah.cards.WhiteCard;

public class GameDeck {
	//	Fields
	public static final int WCCOUNT = 90;			//	5 players (4 ghosts + 1 real) with init 7 + 11 draws = 90
	public static final int BCCOUNT = 10;			//	10 rounds in standard game
	public EntityManagerFactory emf;
	public EntityManager em;
	public static final WhiteCard notCard = new WhiteCard();
	
	private LinkedHashSet<WhiteCard> whitedeck = new LinkedHashSet(WCCOUNT); 
	private LinkedHashSet<BlackCard> blackdeck = new LinkedHashSet(BCCOUNT);
	private ArrayList<CardCombos> refcombos	   = new ArrayList<>();
	private int roundnum = 1;					
	
	//	Constructor
	public GameDeck() {
		try {
			emf = Persistence.createEntityManagerFactory("DAH");
			em = emf.createEntityManager();

			System.out.println("In Game Deck Constructor");
			WhiteCard tempWC;
			int i = 0;
			while(i < WCCOUNT) {
				tempWC = randoWCPicks();
				System.out.print(tempWC + "\t");
					if(whitedeck.add(tempWC)) { i++; }
			}

			BlackCard tempBC;
			i = 0;
			while(i < BCCOUNT) {
				tempBC = randoBCPicks();
					if(blackdeck.add(tempBC)) { i++; }
			}
			
			setRefcombos();
		}
		catch(Exception e) {
			System.out.println("Error in Game Deck\n" + e);
		}
	}
	
	//	Accessor Methods
	public LinkedHashSet<WhiteCard> getWhitedeck()	{ return whitedeck; }
	public WhiteCard getWhiteCard() {
		Iterator<WhiteCard> wi = whitedeck.iterator();
		WhiteCard temp = wi.next();
		wi.remove();
		return temp;
	}
	public BlackCard getBlackCard()	{ 
		Iterator<BlackCard> bi = blackdeck.iterator();
		BlackCard temp = bi.next();
		bi.remove();
		return temp;
	}
	
	public int getRoundnum() 		{ return roundnum;	}
	public void setRoundnum()		{ roundnum++;		}
	
	private void setRefcombos() {
		CardCombos temp = new CardCombos();
		String qString = "SELECT c FROM CardCombos c WHERE c.ccbcFKey = :bcKey AND c.ccwcFKey = :wcKey";
		
		for(int i = 0; i < blackdeck.size(); i++) {
			Iterator<BlackCard> bi = blackdeck.iterator();
			BlackCard btemp = bi.next();
			int bc = btemp.getCardID();
			for(int j = 0; j < whitedeck.size(); j++) {
				Iterator<WhiteCard> wi = whitedeck.iterator();
				WhiteCard wtemp = wi.next();
				int wc = wtemp.getcardID();	
				
				Query query = em.createQuery(qString).setParameter("bcKey", bc).setParameter("wcKey", wc);
				List<CardCombos> elementlist = query.getResultList();
				if(elementlist.get(0) != null) {
					refcombos.add(elementlist.get(0));
				}
			}
		}
	}
	public ArrayList<CardCombos> getRefcombos()		{ return refcombos;	}
	
	//	Methods
	private WhiteCard randoWCPicks() {
		WhiteCard temp = new WhiteCard();
		int rando = (int) (Math.random() * 300)+1;							// need way to query db for last WCPKEY
		String qString = "SELECT w FROM WhiteCard w WHERE w.cardID = :key";
		Query query = em.createQuery(qString).setParameter("key", rando);
		List<WhiteCard> elementList = query.getResultList();
		temp = elementList.get(0);
		return temp;	
	}
	
	private BlackCard randoBCPicks() {
		BlackCard temp = new BlackCard();
		int rando = (int) (Math.random() * 200)+1;							// need way to query db for last BCPKEY
		String qString = "SELECT b FROM BlackCard b WHERE b.cardID = :key";
		Query query = em.createQuery(qString).setParameter("key", rando);
		List<BlackCard> elementList = query.getResultList();
		temp = elementList.get(0);
		return temp;
	}
	
}
