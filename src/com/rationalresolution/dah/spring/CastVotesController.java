package com.rationalresolution.dah.spring;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.rationalresolution.dah.cards.WhiteCard;

@Controller
@RequestMapping("/CastVotes")																//	picks up form action EndOfRound.html from selectwinner.jsp
public class CastVotesController {

	@RequestMapping(method=RequestMethod.POST)	
	public ModelAndView onSubmitFromChoose(@RequestParam("votes") 		String votes,		
										   @RequestParam("card0")		String wcPKeyret,
										   HttpSession session) {
		ModelAndView mv = new ModelAndView("return");
		
/*		GameDeck deck 				= (GameDeck)		session.getAttribute("deck");		//	get deck from session
		JunkPile junkpile 			= (JunkPile)		session.getAttribute("junkpile");	//	get junkpile from session
		Players players 			= (Players)			session.getAttribute("players");	//	get players from session
		WhiteCard[] playersChoices 	= (WhiteCard[])		session.getAttribute("playersChoices");	//	get playersChoices from session
		ArrayList<CardCombos> refcc = (ArrayList<CardCombos>)	session.getAttribute("refcc");	//	get refcc from session
		GameResults gameResults		= (GameResults)		session.getAttribute("gameResults");	//	get gameResults from session
*/		
		WhiteCard wc = bringWhiteCard(Integer.parseInt(wcPKeyret));
		
		String voteregex = "&?votes=([^&]*)";
		List<String> allMatches = new ArrayList<String>();
		Matcher m = Pattern.compile(voteregex).matcher(votes);
		while (m.find()) {
			allMatches.add(m.group());
		}
		
		for (String string : allMatches) {
			System.out.println("DEBUG! In CastVotesController. vote = " + string);
			if(string == "pg13") 		{ wc.setPg13(); 	}
			if(string == "xxx")			{ wc.setXxx(); 		}
			if(string == "dunno")		{ wc.setDunno(); 	}
			if(string == "gross")		{ wc.setGross();	}
			if(string == "inapprop")	{ wc.setInapprop();	}
		}
		return mv;
	}

	
	public WhiteCard bringWhiteCard(int wcPKey) {
		EntityManagerFactory emf;
		EntityManager em;
		emf = Persistence.createEntityManagerFactory("DAH");
		em = emf.createEntityManager();
		
		WhiteCard temp = (WhiteCard) em.createQuery("SELECT w from WhiteCard w WHERE w.cardID = :key").setParameter("key", wcPKey).getSingleResult();
		if(temp != null) {
			return temp;
		}
		else {													//	FIGURE OUT WHAT TO DO WITH NULL RETURN
			System.out.println("WhiteCard not found.");
			return new WhiteCard();
		}
	}
}
