package com.rationalresolution.dah.spring;

import java.util.ArrayList;

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
@RequestMapping("/EndOfRound")																//	picks up form action EndOfRound.html from selectwinner.jsp
public class EndOfRoundController {

	@RequestMapping(method=RequestMethod.POST)	
	public ModelAndView onSubmitFromChoose(@RequestParam("blackcardID") String bcPKey,		//	String of blackcard id from selectwinner.jsp
										   @RequestParam("roundwinner") String roundwinner,	//	String of roundwinner (indicating player) from selectwinner.jsp
										   HttpSession session) {
		ModelAndView mv = new ModelAndView("showwinner");
		
		GameDeck deck 				= (GameDeck)		session.getAttribute("deck");		//	get deck from session
		JunkPile junkpile 			= (JunkPile)		session.getAttribute("junkpile");	//	get junkpile from session
		Players players 			= (Players)			session.getAttribute("players");	//	get players from session
		WhiteCard[] playersChoices 	= (WhiteCard[])		session.getAttribute("playersChoices");	//	get playersChoices from session
		ArrayList<CardCombos> refcc = (ArrayList<CardCombos>)	session.getAttribute("refcc");	//	get refcc from session
		GameResults gameResults		= (GameResults)		session.getAttribute("gameResults");	//	get gameResults from session
		
/*	REMOVE v1.0 */				System.out.println("DEBUG! In EndofRoundController.java\n");
		BlackCard blackcardforround = bringBlackCard(Integer.parseInt(bcPKey));				//	uses method to get blackcard from DB
/*	REMOVE v1.0 */				System.out.println("DEBUG! In EndofRoundController (after bringBlackKey(bcKey))\t" + blackcardforround.toString());
/*	REMOVE v1.0 */				System.out.println("DEBUG! In EndofRoundController. Round #" + deck.getRoundnum() + "(roundnum*5)-5 = " + ((deck.getRoundnum() * 5) -5));
/*	REMOVE v1.0 				System.out.println("DEBUG! In EndofRoundController. Is anything in junkpile?\n" + junkpile.toString()); */

		WhiteCard winningCard;
		int winnernum;
		String winavatar;
		int junkrange = ((deck.getRoundnum() * 5)-5);										//	junkpile should get 5 cards per round so 1st set 0-5, 2nd 6-10, etc.
		switch(roundwinner) {																//	switch on name of player who won
			case "localPlayer":	winnernum = 0;
								players.getLocalPlayer().setHandsWon();						//	player attribute HandsWon increased by 1
								players.getLocalPlayer().setHorriblePoints(10);				//	player attribute HorriblePoints increased 10 points
								break;
			case "Blinky":		winnernum = 1;
								break;
			case "Pinky":		winnernum = 2;
								break;
			case "Inky":		winnernum = 3;
								break;
			case "Clyde":		winnernum = 4;
								break;
			default:			winningCard = new WhiteCard();
								winnernum = 99;
								System.out.println("Something has gone terribly wrong in NextRoundController when trying to switch on winningCard");
								break;
		}
		winningCard = junkpile.getJunkPile(junkrange + winnernum);
		winningCard.setWins();
		deck.setRoundWinner(winningCard);
		players.setPoints(winnernum);
		System.out.println("Here is what winnernum is: " + winnernum);
		winavatar = players.getAvatars(winnernum);
		System.out.println("Here is what is in winavatar: " + winavatar);
		
/*	REMOVE v1.0 */				System.out.println("DEBUG! EndOfRoundController. Is (deck.getRoundnum()-1) the problem? " + (deck.getRoundnum()-1));
		mv.addObject("blackcard", blackcardforround);
/*	REMOVE v1.0 */				System.out.println("DEBUG! In EndofRoundController. blackcardforround = " + blackcardforround.toString());
		mv.addObject("winningCard", winningCard);
/*	REMOVE v1.0 */				System.out.println("DEBUG! In EndofRoundController. junkpile start = " + junkrange + "winningCard = " + winningCard.toString());
		mv.addObject("endOfRound", deck.getRoundnum());
		mv.addObject("winavatar", winavatar);
		deck.setRoundnum();
/*	REMOVE v1.0 */				System.out.println("DEBUG! In EndofRoundController. roundnum = " + deck.getRoundnum());
		
		
		gameResults.setLocalPlayer1Score(players.getPoints(0));						//	set points for players
		gameResults.setBlinkyScore(players.getPoints(1));
		gameResults.setPinkyScore(players.getPoints(2));
		gameResults.setInkyScore(players.getPoints(3));
		gameResults.setClydeScore(players.getPoints(4));
		
		CardCombos winningcomboforround = new CardCombos(bcPKey, ("" + winningCard.getcardID()));		//	temp holder of card combo
		
		if(refcc.contains(winningcomboforround)) {									//	if card combo is in refcc, increase count 
			refcc.get(refcc.indexOf(winningcomboforround)).setCount();
		}
		else {
			refcc.add(winningcomboforround);										//	if new card combo, add to refcc
		}
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
