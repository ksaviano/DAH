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
		deck.getBlackCard();
	}
	
	public static void dealNextRound(@ModelAttribute("players")  Players players, 
									 @ModelAttribute("deck") 	 GameDeck deck,
									 @ModelAttribute("junkpile") JunkPile junkpile) {	//	ROUND OF PLAY STEP 7
		for(int i = 0; i < 7; i++) {
			if(players.getLocalPlayer().getHand()[i] == null) {
				players.getLocalPlayer().setHand(deck.getWhiteCard(), i);
				players.getLocalPlayer().getHand()[i].setDealt();
			}
		}
		
		for(int i = 1; i < 5; i++) {
			for(int j = 0; j < 7; j++) {
				if(players.getGhostPlayer(i).getHand()[j] == null) {
					players.getGhostPlayer(i).setHand(deck.getWhiteCard(), j);
					players.getGhostPlayer(i).getHand()[j].setDealt();
				}
			}
		}
		deck.getBlackCard();
	}
	
	public BlackCard flipBlackCard(@ModelAttribute("deck")	GameDeck deck) {									//	ROUND OF PLAY STEP 1
		return deck.getBlackCard();
	}
}
