package com.rationalresolution.dah.spring;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.rationalresolution.dah.cards.WhiteCard;
import com.rationalresolution.dah.mech.DealCards;
import com.rationalresolution.dah.mech.GameDeck;
import com.rationalresolution.dah.mech.JunkPile;
import com.rationalresolution.dah.players.LocalPlayer;
import com.rationalresolution.dah.players.Players;

@Controller
// @SessionAttributes(value={"deck", "junkpile", "players", "roundnum" })
@RequestMapping("/StartGame")
public class StartGameController {
	
/*	@ModelAttribute("deck")
	public GameDeck bringDeck() {
		System.out.println("in StartGameController.bringDeck");
		return new GameDeck();
	}
	
	@ModelAttribute("junkpile")
	public JunkPile bringJunkPile() {
		System.out.println("in StartGameController.bringJunkPile");
		return new JunkPile();
	}
	
	@ModelAttribute("players")
	public Players bringPlayers() {
		System.out.println("in StartGameController.bringPlayers");
		return new Players();
	}
	
	@ModelAttribute("roundnum")
	public int bringRoundnum() {
		System.out.println("in StartGameController.bringRoundnum");
		return 1;
	}*/
	
	@RequestMapping(method=RequestMethod.POST)
	public ModelAndView onStartOfGame(HttpSession session) {
/*	public ModelAndView onStartOfGame(  @ModelAttribute("player") LocalPlayer pl,
										@ModelAttribute("deck") GameDeck deck,
										@ModelAttribute("junkpile") JunkPile junkpile,
										@ModelAttribute("players") Players players,
										@ModelAttribute("roundnum") int roundnum) {*/
		ModelAndView mv = new ModelAndView("choosecard");									// next Controller = 
		LocalPlayer pl = (LocalPlayer) session.getAttribute("localPlayer");
		
		GameDeck deck = new GameDeck();
		JunkPile junkpile = new JunkPile();
		Players players = new Players();
		
		System.out.println("DEBUG! In Start Game Controller.java\n" + pl.toString() );
		
		players.setLocalPlayer(pl);
		DealCards.dealStart(players, deck, junkpile);
		
		WhiteCard[] currentHand = players.getLocalPlayer().getHand();
		mv.addObject("card0", currentHand[0]);
		mv.addObject("card1", currentHand[1]);
		mv.addObject("card2", currentHand[2]);
		mv.addObject("card3", currentHand[3]);
		mv.addObject("card4", currentHand[4]);
		mv.addObject("card5", currentHand[5]);
		mv.addObject("card6", currentHand[6]);
		mv.addObject("blackcard", deck.getBlackCard());
		
		session.setAttribute("deck", deck);
		session.setAttribute("junkpile", junkpile);
		session.setAttribute("players", players);

		return mv;
	}
}
