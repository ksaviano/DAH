package com.rationalresolution.dah.spring;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.http.HttpSession;

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
@RequestMapping("/SelectWinner")																	//	picks up form action SelectWinner.html from choosecard.jsp
public class SelectWinnerController {
	
	@RequestMapping(method=RequestMethod.POST)	
	public ModelAndView onSubmitFromChoose(@RequestParam("blackcardID") int bcPKey, 				//	blackcardID comes as string from choosecard.jsp
										   @RequestParam("playerchoice") String playerchoice, 		//	playerchoice is card# from choosecard.jsp
										   HttpSession session) {
		ModelAndView mv = new ModelAndView("selectwinner");											//	send to selectwinner.jsp
		
		WhiteCard[] playersChoices = new WhiteCard[5];												//	temp array to capture 5 selected cards from LocalPlayer and Ghosts
		Players players 	= (Players) 	session.getAttribute("players");						//	gets players from session
		JunkPile junkpile	= (JunkPile)	session.getAttribute("junkpile");						//	gets junkpile from session
		ArrayList<CardCombos> refcc	= (ArrayList<CardCombos>)	session.getAttribute("refcc");		//	gets refcc from session
		BlackCard blackcardforround = bringBlackCard(bcPKey);										//	method call uses String of blackcardID to get blackcard from DB (consider change to avoid DB call)
		
/*	REMOVE v1.0 */				System.out.println("DEBUG! In SelectWinnerController.java\n");
/*	REMOVE v1.0 */				System.out.println("DEBUG! SelectWinnerController (after bringBlackKey(bcKey))\t" + blackcardforround.toString());
		
		WhiteCard playerwc;																			//	set temp WhiteCard to capture playerchoice
		int playerwcArraySpot = 0;																	//	set temp int to capture array spot for players hand
		switch(playerchoice) {
			case "card0":	playerwc = players.getLocalPlayer().getHand()[0];						//	getHand returns card and removes from players hand
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
/*	REMOVE v1.0 */				System.out.println("DEBUG! SelectWinnerController (after switch on playerchoice)\t" + playerwc.toString());
		players.getPlayers()[0].decideCard(playerwcArraySpot, session);
		playersChoices[0] = players.getPlayers()[0].playCard(playerwcArraySpot);					//	set LocalPlayer card in temp array
		for (int i = 1; i < playersChoices.length; i++) {											//	loops through ghosts (1-4)
			playersChoices[i] = players.getPlayers()[i].playCard(players.getPlayers()[i].decideCard(bcPKey, session));	//	ghosts decideCard uses refcc and random to decide card, removes card from ghost's hand
		}
/*	REMOVE v1.0 */		 		System.out.println("DEBUG! Select Winner Controller.\nFirst 2 array spots of playersChoices (following decide card for Ghosts)\n" +
									players.getPlayers()[0].getUsername() + ":\t" + playersChoices[0] + "\n" +
									players.getPlayers()[1].getUsername() + ":\t" + playersChoices[1] + "\n" +
									players.getPlayers()[2].getUsername() + ":\t" + playersChoices[2] + "\n" +
									players.getPlayers()[3].getUsername() + ":\t" + playersChoices[3] + "\n" +
									players.getPlayers()[4].getUsername() + ":\t" + playersChoices[4] + "\n"
									);
		
		mv.addObject("blackcard", blackcardforround);												//	blackcard sent to selectwinner.jsp as object
		session.setAttribute("playersChoices", playersChoices);										//	playersChoices set as sessionattribute
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
