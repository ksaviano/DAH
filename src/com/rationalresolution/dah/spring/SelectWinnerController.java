package com.rationalresolution.dah.spring;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.rationalresolution.dah.cards.*;
import com.rationalresolution.dah.mech.*;
import com.rationalresolution.dah.players.*;

@Controller
@SessionAttributes(value={"deck", "junkpile", "players", "roundnum", "playerschoices" })
@RequestMapping("/SelectWinner")
public class SelectWinnerController {
	
	@ModelAttribute("playersChoices")
	public WhiteCard[] bringPlayersChoices() {
		System.out.println("inSelectWinnerController.bringPlayersChoices");
		return new WhiteCard[5];
	}

	@RequestMapping(method=RequestMethod.POST)	
	public ModelAndView onSubmitFromChoose(	@ModelAttribute("deck") GameDeck deck,
											@ModelAttribute("junkpile") JunkPile junkpile,
											@ModelAttribute("players") Players players,
											@ModelAttribute("roundnum") int roundnum,
											@ModelAttribute("playersChoices") WhiteCard[] playersChoices,
											@RequestParam("blackcardID") int bcPKey,
											@RequestParam("playerchoice") String playerchoice) {
		ModelAndView mv = new ModelAndView("selectwinner");
		
		System.out.println("DEBUG! In SelectWinnerController.java\n");
		BlackCard blackcardforround = bringBlackCard(bcPKey);
		System.out.println("DEBUG! SelectWinnerController (after bringBlackKey(bcKey))\t" + blackcardforround.toString());
		
		WhiteCard playerwc;
		int playerwcArraySpot = 0;
		switch(playerchoice) {
			case "card0":	playerwc = players.getLocalPlayer().getHand()[0];
							playerwcArraySpot = 0;
							break;
			case "card1":	playerwc = players.getLocalPlayer().getHand()[1];
							playerwcArraySpot = 1;
							break;
			case "card2":	playerwc = players.getLocalPlayer().getHand()[2];
							playerwcArraySpot = 2;
							break;
			case "card3":	playerwc = players.getLocalPlayer().getHand()[3];
							playerwcArraySpot = 3;
							break;
			case "card4":	playerwc = players.getLocalPlayer().getHand()[4];
							playerwcArraySpot = 4;
							break;
			case "card5":	playerwc = players.getLocalPlayer().getHand()[5];
							playerwcArraySpot = 5;
							break;
			case "card6":	playerwc = players.getLocalPlayer().getHand()[6];
							playerwcArraySpot = 6;
							break;
			default:		System.out.println("DEBUG! playerchoice return incorrect!");
							playerwc = new WhiteCard();
							break;
		}
		System.out.println("DEBUG! SelectWinnerController (after swithc on playerchoice)\t" + playerwc.toString());
		
		for (int i = 1; i < 5; i++) {
			playersChoices[i] = players.getPlayers()[i].getHand()[players.getPlayers()[i].decideCard()];
		}
		playersChoices[0] = players.getPlayers()[0].getHand()[playerwcArraySpot];
		System.out.println("DEBUG! First 2 array spots of playersChoices (following decide card for Ghosts)" +
							players.getPlayers()[0].getUsername() + ":\t" + playersChoices[0] + "\n" +
							players.getPlayers()[1].getUsername() + ":\t" + playersChoices[1]);
		
		mv.addObject("blackcard", blackcardforround);
		return mv;
	}
	
	public BlackCard bringBlackCard(int bcPKey) {
		EntityManagerFactory emf;
		EntityManager em;
		emf = Persistence.createEntityManagerFactory("DAH");
		em = emf.createEntityManager();
		
		BlackCard temp = (BlackCard) em.createQuery("SELECT b from BlackCard b WHERE b.cardID = :key").setParameter("key", bcPKey).getSingleResult();
		if(temp != null) {
			return temp;
		}
		else {													//	FIGURE OUT WHAT TO DO WITH NULL RETURN
			System.out.println("BlackCard not found.");
			return new BlackCard();
		}
	}
	
}
