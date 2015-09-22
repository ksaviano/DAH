package com.rationalresolution.dah.spring;

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
//	@SessionAttributes(value={"deck", "junkpile", "players", "roundnum", "playersChoices" })
@RequestMapping("/EndOfGame")
public class EndofGameController {
	public EntityManagerFactory emf;
	public EntityManager em;
	
/*	@ModelAttribute("playersChoices")
	public WhiteCard[] bringPlayersChoices() {
		System.out.println("inSelectWinnerController.bringPlayersChoices");
		return new WhiteCard[5];
	}*/

	@RequestMapping(method=RequestMethod.POST)	
	public ModelAndView onSubmitFromChoose(HttpSession session) {
/*	public ModelAndView onSubmitFromChoose(	@ModelAttribute("deck") GameDeck deck,
											@ModelAttribute("junkpile") JunkPile junkpile,
											@ModelAttribute("players") Players players,
											@ModelAttribute("roundnum") int roundnum,
											@ModelAttribute("playersChoices") WhiteCard[] playersChoices,
											@RequestParam("blackcardID") int bcPKey,
											@RequestParam("playerchoice") String playerchoice) {*/
		
		GameDeck deck				= (GameDeck)	session.getAttribute("deck");
		JunkPile junkpile			= (JunkPile)	session.getAttribute("junkpile");
		Players players				= (Players)		session.getAttribute("players");
		GameResults gameResults		= (GameResults) session.getAttribute("gameResults");
		
		
		System.out.println("In EndOfGameController. Kill session. quit.");
		
		
		try {
			emf = Persistence.createEntityManagerFactory("DAH");
			em = emf.createEntityManager();
			if(deck.getWhitedeck().size() != 0) {
				// not all cards went to junkpile
				System.out.println("DEBUG! EndofGameController: not all cards from whitedeck were discarded to junkpile!");
				System.out.println("EXITING SYSTEM!");
				System.exit(0);
			}
			
			for(int i = 0; i < junkpile.getJunkPile().size(); i++) {
				em.getTransaction().begin();
				em.merge(junkpile.getJunkPile(i));
				em.getTransaction().commit();
				em.close();
			}
			
			em.getTransaction().begin();
			em.merge(players.getLocalPlayer());
			em.getTransaction().commit();
			em.close();
			
			em.getTransaction().begin();
			em.merge(gameResults);
			em.getTransaction().commit();
			em.close();
			emf.close();
		}
		catch(Exception e) {
			System.out.println("EndofGameController exception: " + e);
		}
		
		session.invalidate();
		return new ModelAndView("index");
	}
}
