package com.rationalresolution.dah.spring;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.rationalresolution.dah.cards.CardCombos;
import com.rationalresolution.dah.cards.WhiteCard;
import com.rationalresolution.dah.mech.DealCards;
import com.rationalresolution.dah.mech.GameDeck;
import com.rationalresolution.dah.mech.GameResults;
import com.rationalresolution.dah.mech.JunkPile;
import com.rationalresolution.dah.players.LocalPlayer;
import com.rationalresolution.dah.players.Players;

@Controller
@RequestMapping("/StartGame")													//	picks up form action StartGame.html from profile.jsp
public class StartGameController {
	
	@RequestMapping(method=RequestMethod.POST)
	public ModelAndView onStartOfGame(@RequestParam("roundsel") String rounds, HttpSession session) {
		ModelAndView mv = new ModelAndView("choosecard");						//	send to choosecard.jsp
		GameDeck.setTotalRounds(Integer.parseInt(rounds));
		LocalPlayer pl = (LocalPlayer) session.getAttribute("localPlayer");		//	pulls localPlayer from session (to be put into players class with ghosts)
		
		GameDeck deck 				= new GameDeck();							//	creation of a new deck sets a LOT into motion
		JunkPile junkpile 			= new JunkPile();							//	junkpile is empty
		Players players 			= new Players();							//	creates players class and "summons" 4 ghost players (array spots 1-4)
		ArrayList<CardCombos> refcc	= deck.getRefcombos();						//	uses deck to bring all previous combos into ArrayList (will be used for updates)
		GameResults gameResults 	= new GameResults();						//	used to hold results of game for DB
/*	REMOVE v1.0 */		System.out.println("DEBUG! In Start Game Controller.java\n" + pl.toString() );
		
		players.setLocalPlayer(pl);												//	adds the localPlayer to players (can remove localPlayer from session?)
		players.setAvatars();
		DealCards.dealStart(players, deck, junkpile);							//	pulls 7 white cards out of whitedeck for each player (7 * 5 = 35), sets dealt increase on cards
		gameResults.setLocalPlayerID(pl.getPlayerID());							//	add LocalPlayer key to GameResults
		
		WhiteCard[] currentHand = players.getLocalPlayer().getHand();			//	Array has current cards of LocalPlayer
		mv.addObject("card0", currentHand[0]);									//	This information does not need to persist, so add as object (0-6)
		mv.addObject("card1", currentHand[1]);
		mv.addObject("card2", currentHand[2]);
		mv.addObject("card3", currentHand[3]);
		mv.addObject("card4", currentHand[4]);
		mv.addObject("card5", currentHand[5]);
		mv.addObject("card6", currentHand[6]);
		mv.addObject("blackcard", deck.getBlackCard());							//	Select blackcard (removed from blackdeck)
		
		session.setAttribute("deck", deck);
		session.setAttribute("junkpile", junkpile);
		session.setAttribute("players", players);
		session.setAttribute("refcc", refcc);
		session.setAttribute("gameResults", gameResults);

		return mv;
	}
}
