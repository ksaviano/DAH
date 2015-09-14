package com.rationalresolution.dah.mech;

import com.rationalresolution.dah.players.*;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.rationalresolution.dah.cards.*;

@Controller
@SessionAttributes
public class DealCards {
	
	//	Fields
//	private GameDeck deck = new GameDeck();
	
	
	//	Methods
	public static void dealStart(@ModelAttribute("players")  Players players, 
								 @ModelAttribute("deck")     GameDeck deck,
								 @ModelAttribute("junkpile") JunkPile junkpile) {		//	ROUND OF PLAY STEP 0
		for(int i = 0; i < 7; i++) {
			for (Player player : players.getPlayers()) {
				WhiteCard temp = deck.getWhiteCard();
				temp.setDealt();
				player.setHand(temp, i);
				System.out.println(player.toString() + "\t" + i + "\t" + player.getHand()[i].toString());
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
	
	public BlackCard flipBlackCard(@ModelAttribute("deck")	GameDeck deck) {									//	ROUND OF PLAY STEP 1
		return deck.getBlackCard();
	}
}
