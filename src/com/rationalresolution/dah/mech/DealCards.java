package com.rationalresolution.dah.mech;

import com.rationalresolution.dah.players.*;
import com.rationalresolution.dah.cards.*;

//	NOT A PERSISTENT CLASS
public class DealCards {
	
	//	Fields
	private GameDeck deck = new GameDeck();
	
	//	Methods
	public static void dealStart(Players players, GameDeck deck) {		//	ROUND OF PLAY STEP 0
		for(int i = 0; i < 7; i++) {
			for (Player player : players.getPlayers()) {
				WhiteCard temp = deck.getWhiteCard();
				temp.setDealt();
//				player.setHand(temp, i);
				temp = null;
			}
		}
	}
	
	public static void dealNextRound(Player[] players, GameDeck deck) {	//	ROUND OF PLAY STEP 7
		//	find empty slot in player hand, insert there
		for (Player player : players) {
			int i;
			WhiteCard temp = deck.getWhiteCard();
			WhiteCard[] playerhand = player.getHand();
			for (i = 0; i < 7; i++) {
				if(playerhand[i] == null) {
					break;
				}
			temp.setDealt();
			player.setHand(temp, i);
			temp = null;
			}
		}
	}
	
	public BlackCard flipBlackCard() {									//	ROUND OF PLAY STEP 1
		return deck.getBlackCard();
	}
}
