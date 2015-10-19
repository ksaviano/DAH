package com.rationalresolution.dah.spring;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.rationalresolution.dah.cards.BlackCard;
import com.rationalresolution.dah.cards.WhiteCard;
import com.rationalresolution.dah.mech.DealCards;
import com.rationalresolution.dah.mech.GameDeck;
import com.rationalresolution.dah.mech.JunkPile;
import com.rationalresolution.dah.players.Players;

@Controller
@RequestMapping("/NextRound2")
public class RESTController1 {
	
	@RequestMapping(method=RequestMethod.POST)
	public ModelAndView onNextRound(HttpSession session) {
		ModelAndView mv;
		
		GameDeck deck 		= (GameDeck)	session.getAttribute("deck");
		Players players 	= (Players) 	session.getAttribute("players");
		JunkPile junkpile	= (JunkPile)	session.getAttribute("junkpile");
		
		System.out.println("DEBUG! In NextRoundController. roundnum = " + deck.getRoundnum());
		if(deck.getRoundnum() < (deck.getTotalRounds()+1)) {		
			mv = new ModelAndView("choosecard");
		}
		else {
			mv = new ModelAndView("endofgame");
			
			return mv;
		}
		DealCards.dealNextRound(players, deck, junkpile);
		return mv;
	}
/*
	@RequestMapping("/getPlayerHand")
	@ResponseBody
	public WhiteCard[] getPlayerHandJSON(HttpSession session) {
		Players players 	= (Players) 	session.getAttribute("players");
		return players.getLocalPlayer().getHand();
	}
	
	@RequestMapping("/getBlackCard")
	@ResponseBody
	public BlackCard getBlackCardJSON(HttpSession session) {
		GameDeck deck 		= (GameDeck)	session.getAttribute("deck");
		return deck.getBlackCard();
	}
	
	@RequestMapping("/getRoundNum")
	@ResponseBody
	public int getRoundNumJSON(HttpSession session) {
		GameDeck deck 		= (GameDeck)	session.getAttribute("deck");
		return deck.getRoundnum();
	}
*/	
	
	
	
	
}
