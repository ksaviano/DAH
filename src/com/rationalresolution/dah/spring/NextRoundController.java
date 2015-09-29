package com.rationalresolution.dah.spring;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.rationalresolution.dah.cards.WhiteCard;
import com.rationalresolution.dah.mech.DealCards;
import com.rationalresolution.dah.mech.GameDeck;
import com.rationalresolution.dah.mech.JunkPile;
import com.rationalresolution.dah.players.LocalPlayer;
import com.rationalresolution.dah.players.Players;

@Controller
@RequestMapping("/NextRound")
public class NextRoundController {
	
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
		
//		System.out.println("DEBUG! In NextRound Controller.java\n" + pl.toString() );
		DealCards.dealNextRound(players, deck, junkpile);
		
		WhiteCard[] currentHand = players.getLocalPlayer().getHand();
		mv.addObject("card0", currentHand[0]);
		mv.addObject("card1", currentHand[1]);
		mv.addObject("card2", currentHand[2]);
		mv.addObject("card3", currentHand[3]);
		mv.addObject("card4", currentHand[4]);
		mv.addObject("card5", currentHand[5]);
		mv.addObject("card6", currentHand[6]);
		mv.addObject("blackcard", deck.getBlackCard());
		
		

		return mv;
	}
}
