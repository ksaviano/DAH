package com.rationalresolution.dah.mech;

import com.rationalresolution.dah.players.*;
import com.rationalresolution.dah.cards.*;

//	NOT A PERSISTENT CLASS
public class DealCards {
	
	//	Fields
	private GameDeck deck = new GameDeck();
	
	//	Methods
	public void dealStart(Player[] players, GameDeck deck) {		//	ROUND OF PLAY STEP 0
		for(int i = 0; i < 7; i++) {
			for (Player player : players) {
				player.setHand(deck.getWhiteCards(), i);
			}
		}
	}
	
	public void dealNextRound(Player[] players, GameDeck deck) {	//	ROUND OF PLAY STEP 7
		//	find empty slot in player hand, insert there
		for (Player player : players) {
			int i;
			WhiteCard[] playerhand = player.getHand();
			for (i = 0; i < 7; i++) {
				if(playerhand[i] == null) {
					break;
				}
			player.setHand(deck.getWhiteCards(), i);
			}
		}
	}
	
	public BlackCard flipBlackCard() {			//	ROUND OF PLAY STEP 1
		return deck.getBlackCards();
	}
}
