package com.rationalresolution.dah.spring;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.rationalresolution.dah.players.*;
import com.rationalresolution.dah.cards.*;
import com.rationalresolution.dah.mech.*;

@Controller
@SessionAttributes(value={"player", "deck", "junkpile"})
@RequestMapping("/StartGame")
public class StartGameController {
	
	@ModelAttribute("player")
	public LocalPlayer bringPlayer() {
		return new LocalPlayer();
	}
	
	@ModelAttribute("deck")
	public GameDeck bringDeck() {
		return new GameDeck();
	}
	
	@ModelAttribute("junkpile")
	public JunkPile bringJunkPile() {
		return new JunkPile();
	}
	
	@ModelAttribute("players")
	public Players bringPlayers() {
		return new Players();
	}

	@RequestMapping(method=RequestMethod.POST)
	public ModelAndView onStartOfGame(  @ModelAttribute("player") LocalPlayer pl,
										@ModelAttribute("deck") GameDeck deck,
										@ModelAttribute("junkpile") JunkPile junkpile,
										@ModelAttribute("players") Players players,
										@RequestParam("username") String u,
										@RequestParam("password") String p) {
		ModelAndView mv = new ModelAndView("choosecard");
		//	DEBUG!
		System.out.println("DEBUG! In Start Game Controller.java\n" + p );
		pl.setUsername(u);
		pl.setPassword(p);
		players.setLocalPlayer(pl);
		DealCards.dealStart(players, deck);
		System.out.println(players.getLocalPlayer().getHand()[1]);
		
		WhiteCard[] currentHand = players.getLocalPlayer().getHand();
		mv.addObject("card0", currentHand[0]);
		mv.addObject("card1", currentHand[1]);
		mv.addObject("card2", currentHand[2]);
		mv.addObject("card3", currentHand[3]);
		mv.addObject("card4", currentHand[4]);
		mv.addObject("card5", currentHand[5]);
		mv.addObject("card6", currentHand[6]);
		mv.addObject("blackcard", deck.getBlackCard());
		mv.addObject("players", players);
		mv.addObject("deck", deck);
		mv.addObject("junkpile", junkpile);
		
		
		return mv;
	}
}
