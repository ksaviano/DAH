package com.rationalresolution.dah.mech;

import java.util.Stack;

import com.rationalresolution.dah.cards.*;

public class GameDeck {
	//	Fields
	public static final int WCCOUNT = 85;			//	5 players (4 ghosts + 1 real) with init 7 + 10 draws = 85
	public static final int BCCOUNT = 10;			//	10 rounds in standard game
	private Stack<WhiteCard> whiteCards;
	private Stack<BlackCard> blackCards;
	
	
	WhiteCard HOLDER = new WhiteCard("HOLDER");
	BlackCard SAMPLE = new BlackCard();
	
	//	Constructor
	public GameDeck() {
		for(int i = 0; i < WCCOUNT; i++) {
			whiteCards.push(randoWCPick());
		}
		for(int j = 0; j < BCCOUNT; j++) {
			blackCards.push(randoBCPick());
		}
	}
	
	//	Accessor Methods
	public WhiteCard getWhiteCards()	{ return whiteCards.pop();	}
	public BlackCard getBlackCards()	{ return blackCards.pop();	}
	
	public void setWhiteCards()			{ whiteCards.push(randoWCPick());	}
	public void setBlackCards()			{ blackCards.push(randoBCPick());	}
					
	//	Methods
	public WhiteCard randoWCPick() {
		//	pick random WhiteCard from table
		//	ensure it is not in current deck
		
		return HOLDER;
	}
	
	public BlackCard randoBCPick() {
		//	pick random BlackCard from table
		//	ensure it is not in current deck
		
		return SAMPLE;
	}
}
