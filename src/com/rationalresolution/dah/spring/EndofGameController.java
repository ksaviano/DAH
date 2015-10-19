package com.rationalresolution.dah.spring;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.rationalresolution.dah.cards.*;
import com.rationalresolution.dah.mech.*;
import com.rationalresolution.dah.players.*;

@Controller
public class EndofGameController {
	public EntityManagerFactory emf;
	public EntityManager em;
	
	@RequestMapping(path="/DBCommit", method=RequestMethod.POST)	
	public String committoDB(HttpSession session) {
		
		GameDeck deck				= (GameDeck)				session.getAttribute("deck");		//	get deck from session
		JunkPile junkpile			= (JunkPile)				session.getAttribute("junkpile");	//	get junkpile from session
		Players players				= (Players)					session.getAttribute("players");	//	get players from session
		ArrayList<CardCombos> refcc = (ArrayList<CardCombos>)	session.getAttribute("refcc");		//	get refcc from session
		GameResults gameResults		= (GameResults) 			session.getAttribute("gameResults");//	get ganeResults from session
		WhiteCard[] playersChoices	= (WhiteCard[])				session.getAttribute("playersChoices");
		LocalPlayer localplayer		= (LocalPlayer)				session.getAttribute("localPlayer");
		
		int handsize = players.getLocalPlayer().getHand().length;
		
		for(int i = 0; i < players.getPlayers().length; i++) {				//	discard all remaining cards from each player's hand to junkpile
			for(int j = 0; j < handsize; j++) {
				if(players.getGhostPlayer(i).getHand()[j] != null) {
					players.getGhostPlayer(i).discard(j);
				}
			}
		}
		
		LinkedHashSet<WhiteCard> whitedeck = deck.getWhitedeck();			//	discard remaining cards from hand
		Iterator<WhiteCard> wi = whitedeck.iterator();
		while(wi.hasNext()) {
			WhiteCard temp = wi.next();
			if(temp != null) {
				junkpile.setJunkPile(temp);
				wi.remove();
			}
		}
		
			if(whitedeck.isEmpty()) {
				System.out.println("DEBUG... EndofGameController. WhiteDeck is empty");
				System.out.println("DEBUG... EndofGameController. JunkPile has " + junkpile.getJunkPile().size() + " WCCOUNT: " + deck.WCCOUNT);
			} else {
				System.out.println("DEBUG... EndofGameController. " + whitedeck.size() + " cards left in whitedeck.");
				System.out.println("DEBUG... EndofGameController. JunkPile has " + junkpile.getJunkPile().size() + " WCCOUNT: " + deck.WCCOUNT);
			}
					
		try {
			emf = Persistence.createEntityManagerFactory("DAH");
			em = emf.createEntityManager();
			
			Iterator<WhiteCard> jp = junkpile.getJunkPile().iterator();
			int y = 0;
			while(jp.hasNext()) {
				WhiteCard temp = jp.next();
				if(temp != null) {
					em.getTransaction().begin();
					em.merge(temp);
					em.getTransaction().commit();
					jp.remove();
					y++;
				}
			}
				
				if(junkpile.getJunkPile().isEmpty()) {
					System.out.println("DEBUG... EndofGameController. Junkpile committed " + y + " cards to DB. Junkpile is empty");
				} else {
					System.out.println("DEBUG... EndofGameController. Junkpile committed " + y + " cards to DB. Junkpile has " + junkpile.getJunkPile().size() + "cards left");
				}
				
			players.getLocalPlayer().setGamesPlayed();

			Iterator<CardCombos> cc = refcc.iterator();
			int x = 0;
			while(cc.hasNext()) {
				em.getTransaction().begin();
				em.merge(cc.next());
				em.getTransaction().commit();
				cc.remove();
				x++;
			}
			
				if(refcc.isEmpty()) {
					System.out.println("DEBUG... EndofGameController. refcc committed " + x + " card combos to DB. refcc is empty");
				} else {
					System.out.println("DEBUG... EndofGameController. refcc committed " + x + " card combos to DB. refcc has " + refcc.size() + " combos left");
				}

			em.getTransaction().begin();
			em.merge(players.getLocalPlayer());								//	Commit all changes to LocalPlayer back to DB
			em.getTransaction().commit();

			em.getTransaction().begin();
			em.persist(gameResults);										//	Commit new gameResults to DB
			em.getTransaction().commit();
			
			em.close();
			emf.close();
		}
		catch(Exception e) {
			System.out.println("** ERROR ** EndofGameController. Try block failure: " + e);
		}
		return "endgame";
	}
	
	@RequestMapping(path="/EndGame", method=RequestMethod.POST)
	public String onEndOfGame(HttpSession session) {
		String mv = "../index";
			GameDeck deck 				= (GameDeck)	session.getAttribute("deck");							//	creation of a new deck sets a LOT into motion
			JunkPile junkpile 			= (JunkPile)	session.getAttribute("junkpile");							//	junkpile is empty
			Players players 			= (Players)		session.getAttribute("players");							//	creates players class and "summons" 4 ghost players (array spots 1-4)
			
			ArrayList<CardCombos> refcc	= (ArrayList<CardCombos>)	session.getAttribute("refcc");			//	uses deck to bring all previous combos into ArrayList (will be used for updates)
			GameResults gameResults 	= (GameResults)	session.getAttribute("gameResults");						//	used to hold results of game for DB
			WhiteCard[] playersChoices	= (WhiteCard[])	session.getAttribute("playersChoices");
			LocalPlayer lp				= (LocalPlayer) session.getAttribute("localPlayer");				
			
			deck = null;
			junkpile = null;
			players = null;
			refcc = null;
			gameResults = null;
			playersChoices = null;
			lp = null;
			
		return mv;
	}
}
