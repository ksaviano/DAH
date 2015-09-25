package com.rationalresolution.dah.spring;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.rationalresolution.dah.cards.CardCombos;
import com.rationalresolution.dah.cards.WhiteCard;
import com.rationalresolution.dah.mech.DealCards;
import com.rationalresolution.dah.mech.GameDeck;
import com.rationalresolution.dah.mech.JunkPile;
import com.rationalresolution.dah.players.LocalPlayer;
import com.rationalresolution.dah.players.Players;

@Controller
@RequestMapping("/StartGame")
public class StartGameController {
	
	@RequestMapping(method=RequestMethod.POST)
	public ModelAndView onStartOfGame(HttpSession session) {
		ModelAndView mv = new ModelAndView("choosecard");									
		LocalPlayer pl = (LocalPlayer) session.getAttribute("localPlayer");
		
		GameDeck deck = new GameDeck();
		JunkPile junkpile = new JunkPile();
		Players players = new Players();
		ArrayList<CardCombos> refcc = deck.getRefcombos();
		CardCombos[] cardcombos = new CardCombos[GameDeck.BCCOUNT];
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
		session.setAttribute("cardCombos", cardcombos);
		session.setAttribute("refcc", refcc);

		return mv;
	}
}
