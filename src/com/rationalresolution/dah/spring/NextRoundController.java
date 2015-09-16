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
@SessionAttributes(value={"deck", "junkpile", "players", "roundnum", "playersChoices" })
@RequestMapping("/NextRound")
public class NextRoundController {


	
	@RequestMapping(method=RequestMethod.POST)	
	public ModelAndView onSubmitFromChoose(	@ModelAttribute("deck") GameDeck deck,
											@ModelAttribute("junkpile") JunkPile junkpile,
											@ModelAttribute("players") Players players,
											@ModelAttribute("roundnum") int roundnum,
											@ModelAttribute("playersChoices") WhiteCard[] playersChoices,
											@RequestParam("blackcardID") int bcPKey,
											@RequestParam("roundwinner") String roundwinner) {
		ModelAndView mv = new ModelAndView("nextround");
		
		System.out.println("DEBUG! In NextRoundController.java\n");
		BlackCard blackcardforround = bringBlackCard(bcPKey);
		System.out.println("DEBUG! In NextRoundController (after bringBlackKey(bcKey))\t" + blackcardforround.toString());

		WhiteCard winningCard;
		int winningPlayersArraySpot = 0;
		switch(roundwinner) {
			case "localPlayer":	winningCard = playersChoices[0];
								players.getLocalPlayer().discard(0);
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
