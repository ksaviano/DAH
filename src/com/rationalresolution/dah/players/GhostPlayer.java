package com.rationalresolution.dah.players;

import com.rationalresolution.dah.cards.*;
import javax.persistence.*;


public class GhostPlayer implements Player {
	//	Fields
	private int ghostID;
	private Ghosts ghostName;
	protected WhiteCard[] hand					= new WhiteCard[7];
	
	
	public enum Ghosts { BLINKY, PINKY, INKY, CLYDE };
	
	//	Accessor Methods
	public int getGhostID()						{ return ghostID;	}
	public Ghosts getGhostName()				{ return ghostName;	}
	public WhiteCard[] getHand()				{ return hand;		}
	
	public void setGhostName(Ghosts g)			{ ghostName = g;	}
	public void setHand(WhiteCard wc, int a)	{ hand[a] = wc;	}
	
	//	Methods

	public int decideCard() {					//	ROUND OF PLAY STEP 2
		//	decide which card in hand is best... for now, choose one at random		
		int x = (int) (Math.random() * 7);
		return x;
	}

	public WhiteCard playCard(int x) {			//	ROUND OF PLAY STEP 3
		WhiteCard playedCard = hand[x];
		hand[x] = null;
		return playedCard;
	}
}
