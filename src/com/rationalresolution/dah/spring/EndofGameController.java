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
		System.out.println("In EndOfGameController. Kill session. quit.");
		session.invalidate();
		return new ModelAndView("index");
	}
}
