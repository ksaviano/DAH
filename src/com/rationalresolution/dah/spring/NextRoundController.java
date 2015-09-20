package com.rationalresolution.dah.spring;

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
@SessionAttributes(value={"deck", "junkpile", "players", "roundnum", "playersChoices" })
@RequestMapping("/NextRound")
public class NextRoundController {
	
	@RequestMapping(method=RequestMethod.POST)
	public ModelAndView onStartOfGame(  @ModelAttribute("player") LocalPlayer pl,
										@ModelAttribute("deck") GameDeck deck,
										@ModelAttribute("junkpile") JunkPile junkpile,
										@ModelAttribute("players") Players players,
										@ModelAttribute("roundnum") int roundnum,
										@ModelAttribute("playersChoices") WhiteCard[] playersChoices)
	{
		ModelAndView mv;
		System.out.println("DEBUG! In NextRoundController. roundnum = " + roundnum);
		if(roundnum < 10) {		
			mv = new ModelAndView("choosecard");
		}
		else {
			return new ModelAndView("endofgame");
		}
		
		System.out.println("DEBUG! In NextRound Controller.java\n" + pl.toString() );
		
		
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
