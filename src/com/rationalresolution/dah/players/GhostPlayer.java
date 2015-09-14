package com.rationalresolution.dah.players;

import com.rationalresolution.dah.cards.*;
import com.rationalresolution.dah.mech.JunkPile;

public class GhostPlayer implements Player {
	//	Fields
	private int ghostID;
	private Ghosts ghostname;
	protected WhiteCard[] hand					= new WhiteCard[7];
	
	
	public enum Ghosts { BLINKY, PINKY, INKY, CLYDE };
	
	//	Accessor Methods
	public int getGhostID()						{ return ghostID;	}
	public Ghosts getGhostname()				{ return ghostname;	}
	public String getUsername()					{ return "" + getGhostname(); }
	public WhiteCard[] getHand()				{ return hand;		}
	
	public void setGhostname(Ghosts g)			{ ghostname = g;	}
	public void setHand(WhiteCard wc, int a)	{ hand[a] = wc;	}

	//	Constructor
	public GhostPlayer() {
		
	}
	
	public GhostPlayer(Ghosts g) {
		setGhostname(g);
	}
	
	//	Methods

	public int decideCard() {					//	ROUND OF PLAY STEP 2
		//	decide which card in hand is best... for now, choose one at random		
		int x = (int) (Math.random() * 7);
		return x;
	}

	public WhiteCard playCard(int x) {			//	ROUND OF PLAY STEP 3
		WhiteCard playedCard = hand[x];
		JunkPile.setJunkPile(playedCard);
		playedCard.setPlayed();
		hand[x] = null;
		return playedCard;
	}
	
	public void discard(int x) {
		WhiteCard discardedCard = hand[x];
		JunkPile.setJunkPile(discardedCard);
		hand[x] = null;
	}
	
	public String toString() {
		return "" + getGhostname();
	}
}
