package com.rationalresolution.dah.players;

import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpSession;

import com.rationalresolution.dah.cards.*;
import com.rationalresolution.dah.mech.JunkPile;

public class GhostPlayer implements Player {
	//	Fields
	private int ghostID;
	private Ghosts ghostname;
	protected WhiteCard[] hand					= new WhiteCard[7];
	private WhiteCard roundpick;
	
	
	public enum Ghosts { BLINKY, PINKY, INKY, CLYDE };
	
	//	Accessor Methods
	public int getGhostID()						{ return ghostID;	}
	public Ghosts getGhostname()				{ return ghostname;	}
	public String getUsername()					{ return "" + getGhostname(); }
	public WhiteCard[] getHand()				{ return hand;		}
	public WhiteCard getRoundpick()				{ return roundpick;	}
	
	public void setGhostname(Ghosts g)			{ ghostname = g;	}
	public void setHand(WhiteCard wc, int a)	{ hand[a] = wc;		}
	public void setRoundpick(WhiteCard wc)		{ roundpick = wc;	}

	//	Constructor
	public GhostPlayer() {
		
	}
	
	public GhostPlayer(Ghosts g) {
		setGhostname(g);
	}
	
	//	Methods

	public int decideCard(int bc, HttpSession session) {					//	ROUND OF PLAY STEP 2
		ArrayList<CardCombos> refcc = (ArrayList<CardCombos>) session.getAttribute("refcc");
		
		int[] decider = new int[hand.length];
		int decidertotal = 0;
		for(int i = 0; i < decider.length; i++) {
			decider[i] = (int) (Math.random()*10);
			if(i > 0) {
				decidertotal = decider[i-1] + decider[i];
				decider[i] += decider[i-1];
				System.out.println(this.toString() + " decider[" + i + "] = " + decider[i] + " decider [" + (i-1) + "] = " + decider[i-1]);
			}
		}
		for(int i = 0; i < hand.length; i++) {
			CardCombos temp = new CardCombos(("" + hand[i].getcardID()), ("" + bc));
			if(refcc.contains(temp)) {
				System.out.println("This combination has won before! " );
				return i;
			}
			if(hand[i].getDealt() != 0) {
				decider[i] += ((hand[i].getPlayed() / hand[i].getDealt()) * 10);
			}
		}
		
		
		int x = (int) (Math.random() * decidertotal);
		for(int i = 0; i  < decider.length; i++) {
			if(decider[i] > x ) { 
				System.out.println("Random: " + x + " decider value: " + decider[i] + " array spot " + i);
				setRoundpick(hand[i]);
				return i; 
			}
		}
		return 0;
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
