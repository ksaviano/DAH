package com.rationalresolution.dah.spring;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.rationalresolution.dah.players.*;
import com.rationalresolution.dah.cards.*;
import com.rationalresolution.dah.mech.*;

@Controller
@SessionAttributes(value={"players", "deck", "junkpile"})
@RequestMapping("/Game2")
public class GamePlayController {

	@RequestMapping(value="/", method=RequestMethod.POST)
	public ModelAndView onChooseCardSubmit(@RequestParam("players") Players players,
										   @RequestParam("deck") GameDeck deck,
										   @RequestParam("junkpile") JunkPile junkpile) {
		ModelAndView mv = new ModelAndView("playround");
		WhiteCard[] currentHand = players.getLocalPlayer().getHand();
		mv.addObject("card0", currentHand[0]);
		mv.addObject("card1", currentHand[1]);
		mv.addObject("card2", currentHand[2]);
		mv.addObject("card3", currentHand[3]);
		mv.addObject("card4", currentHand[4]);
		mv.addObject("card5", currentHand[5]);
		mv.addObject("card6", currentHand[6]);
		mv.addObject("players", players);
		mv.addObject("deck", deck);
		mv.addObject("junkpile", junkpile);
		
		
		return mv;
	}
}
