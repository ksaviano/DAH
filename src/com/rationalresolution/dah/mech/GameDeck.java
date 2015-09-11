package com.rationalresolution.dah.mech;

import java.util.Stack;

import javax.persistence.EntityManager;
//  import javax.persistence.EntityManagerFactory;				REMOVE IF NOT NEEDED
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.rationalresolution.dah.cards.*;

public class GameDeck {
	//	Fields
	public static final int WCCOUNT = 90;			//	5 players (4 ghosts + 1 real) with init 7 + 11 draws = 90
	public static final int BCCOUNT = 10;			//	10 rounds in standard game
	private static EntityManager em = null;
	private Stack<WhiteCard> whiteCards;
	private Stack<BlackCard> blackCards;
	int wcCount = ((Number)em.createNamedQuery("CARDWHITECARD.findAll(Count)").getSingleResult()).intValue(); 
	int bcCount = ((Number)em.createNamedQuery("CARDBLACKCARD.findALL(Count)").getSingleResult()).intValue();
	
	//	Constructor
	public GameDeck() {
		System.out.println("In Game Deck Constructor");
		for(int i = 0; i < WCCOUNT; i++) {
			WhiteCard tempWC;
			do {
				tempWC = randoWCPicks();
			} while(whiteCards.search(tempWC) > -1); 
			whiteCards.push(tempWC);
			tempWC = null;
		}
	
		for(int j = 0; j < BCCOUNT; j++) {
			BlackCard tempBC;
			do {
				tempBC = randoBCPicks();
			} while(blackCards.search(tempBC) > -1);
			blackCards.push(tempBC);
			tempBC = null;
		}
	}
	
	//	Accessor Methods
	public WhiteCard getWhiteCard()		{ return whiteCards.pop();	}
	public BlackCard getBlackCard()		{ return blackCards.pop();	}
	
	//	Methods
	private WhiteCard randoWCPicks() {
		return em.find(WhiteCard.class, (Math.random() * wcCount));
	}
	
	private BlackCard randoBCPicks() {
		return em.find(BlackCard.class, (Math.random() * bcCount));
	}
}
