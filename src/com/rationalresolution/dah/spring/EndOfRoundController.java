package com.rationalresolution.dah.spring;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.rationalresolution.dah.cards.BlackCard;
import com.rationalresolution.dah.cards.CardCombos;
import com.rationalresolution.dah.cards.WhiteCard;
import com.rationalresolution.dah.mech.GameDeck;
import com.rationalresolution.dah.mech.GameResults;
import com.rationalresolution.dah.mech.JunkPile;
import com.rationalresolution.dah.players.Players;

@Controller
@RequestMapping("/EndOfRound")
public class EndOfRoundController {


	
	@RequestMapping(method=RequestMethod.POST)	
	public ModelAndView onSubmitFromChoose(@RequestParam("blackcardID") String bcPKey,
										   @RequestParam("roundwinner") String roundwinner,
										   HttpSession session) {
		ModelAndView mv = new ModelAndView("showwinner");
		
		GameDeck deck 				= (GameDeck)		session.getAttribute("deck");
		JunkPile junkpile 			= (JunkPile)		session.getAttribute("junkpile");
		Players players 			= (Players)			session.getAttribute("players");
		WhiteCard[] playersChoices 	= (WhiteCard[])		session.getAttribute("playersChoices");
		CardCombos[] cardcombos		= (CardCombos[])	session.getAttribute("cardcombos");
		
		System.out.println("DEBUG! In EndofRoundController.java\n");
		BlackCard blackcardforround = bringBlackCard(Integer.parseInt(bcPKey));
		System.out.println("DEBUG! In EndofRoundController (after bringBlackKey(bcKey))\t" + blackcardforround.toString());
		System.out.println("DEBUG! In EndofRoundController. Round #" + deck.getRoundnum() + "(roundnum*5)-5 = " + ((deck.getRoundnum() * 5) -5));
		System.out.println("DEBUG! In EndofRoundController. Is anything in junkpile?\n" + junkpile.toString());

		WhiteCard winningCard;
		int junkrange = ((deck.getRoundnum() * 5)-5);
		switch(roundwinner) {
			case "localPlayer":	winningCard = junkpile.getJunkPile(junkrange + 0);
								players.setPoints(0);
								players.getLocalPlayer().setHandsWon();
								players.getLocalPlayer().setHorriblePoints(10);
								break;
			case "Blinky":		winningCard = junkpile.getJunkPile(junkrange + 1);
								players.setPoints(1);
								break;
			case "Pinky":		winningCard = junkpile.getJunkPile(junkrange + 2);
								players.setPoints(2);
								break;
			case "Inky":		winningCard = junkpile.getJunkPile(junkrange + 3);
								players.setPoints(3);
								break;
			case "Clyde":		winningCard = junkpile.getJunkPile(junkrange + 4);
								players.setPoints(4);
								break;
			default:			winningCard = new WhiteCard();
								System.out.println("Something has gone terribly wrong in NextRoundController when trying to switch on winningCard");
								break;
		}
		cardcombos[(deck.getRoundnum()-1)] = new CardCombos(winningCard.getcardID(), Integer.parseInt(bcPKey));
		mv.addObject("blackcard", blackcardforround);
		System.out.println("DEBUG! In EndofRoundController. blackcardforround = " + blackcardforround.toString());
		mv.addObject("winningCard", winningCard);
		System.out.println("DEBUG! In EndofRoundController. junkpile start = " + junkrange + "winningCard = " + winningCard.toString());
		mv.addObject("endOfRound", deck.getRoundnum());
		deck.setRoundnum();
		System.out.println("DEBUG! In EndofRoundController. roundnum = " + deck.getRoundnum());
		
		GameResults gameResults = new GameResults();
		gameResults.setLocalPlayer1Score(players.getPoints(0));
		gameResults.setBlinkyScore(players.getPoints(1));
		gameResults.setPinkyScore(players.getPoints(2));
		gameResults.setInkyScore(players.getPoints(3));
		gameResults.setClydeScore(players.getPoints(4));
		
		session.setAttribute("gameResults", gameResults);
		
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
