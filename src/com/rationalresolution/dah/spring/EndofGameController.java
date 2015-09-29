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
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.rationalresolution.dah.cards.*;
import com.rationalresolution.dah.mech.*;
import com.rationalresolution.dah.players.*;

@Controller
@RequestMapping("/EndOfGame")
public class EndofGameController {
	public EntityManagerFactory emf;
	public EntityManager em;
	
	@RequestMapping(method=RequestMethod.POST)	
	public ModelAndView onSubmitFromChoose(HttpSession session) {
		
		GameDeck deck				= (GameDeck)				session.getAttribute("deck");		//	get deck from session
		JunkPile junkpile			= (JunkPile)				session.getAttribute("junkpile");	//	get junkpile from session
		Players players				= (Players)					session.getAttribute("players");	//	get players from session
		ArrayList<CardCombos> refcc = (ArrayList<CardCombos>)	session.getAttribute("refcc");		//	get refcc from session
		GameResults gameResults		= (GameResults) 			session.getAttribute("gameResults");//	get ganeResults from session
		
		
/*	REMOVE v1.0 */						System.out.println("In EndOfGameController. Kill session. quit.");
		for(int i = 1; i < players.getPlayers().length; i++) {				//	discard remaining ghost cards from hand to junkpile
			for(int j = 0; j < 7; j++) {
				if(players.getGhostPlayer(i).getHand()[j] != null) {
					players.getGhostPlayer(i).discard(j);
				}
			}
		}
		for(int j = 0; j < 7; j++) {										//	discard remaining localPlayer cards from hand to junkpile
			if(players.getLocalPlayer().getHand() != null) {
				players.getLocalPlayer().discard(j);
			}
		}
		
/*	REMOVE v1.0 */	System.out.println("discarded cards from all player hands, junkpile currently at: " + junkpile.getJunkPile().size());
		LinkedHashSet<WhiteCard> whitedeck = deck.getWhitedeck();			//	discard remaining cards from hand
		Iterator<WhiteCard> wi = whitedeck.iterator();
		while(wi.hasNext()) {
			WhiteCard temp = wi.next();
			if(temp != null) {
				junkpile.setJunkPile(temp);
				wi.remove();
			}
		}
/*	REMOVE v1.0 */						System.out.println("In EndOfGameController. After for each, whitedeck size = " + deck.getWhitedeck().size());		
/*		int wcsize = deck.getWhitedeck().size();
		for(int k = 0; k < wcsize; k++) {
			junkpile.setJunkPile(deck.getWhiteCard());
		}*/
		
		if(deck.getWhitedeck().size() != 0) {							//	Make sure that whitedeck has been discarded to junkpile
			// not all cards went to junkpile
/*	REMOVE v1.0 */						System.out.println("DEBUG! EndofGameController: not all cards from whitedeck were discarded to junkpile! Size is: " + deck.getWhitedeck().size());
/*	REMOVE v1.0 */						System.out.println("EXITING SYSTEM!");
			System.exit(0);
		}
		if(junkpile.getJunkPile().size() != deck.WCCOUNT+1) {				//	Make sure that junkpile has all of the whitecards
/*	REMOVE v1.0 */						System.out.println("DEBUG! EndofGameController: not all cards are in the junkpile! Junkpile size is: " + junkpile.getJunkPile().size() + " should be " + deck.WCCOUNT);
/*	REMOVE v1.0 */						System.out.println("EXITING SYSTEM!");
			System.exit(0);
		}
		
//		try {
			emf = Persistence.createEntityManagerFactory("DAH");
			em = emf.createEntityManager();
			
			Iterator<WhiteCard> jp = junkpile.getJunkPile().iterator();
			int y = 0;
			while(jp.hasNext()) {
/*	REMOVE v1.0 */						System.out.println("DEBUG! Committing junkpile transactions: " + y);
				WhiteCard temp = jp.next();
				if(temp != null) {
					em.getTransaction().begin();
					em.merge(temp);
					em.getTransaction().commit();
					jp.remove();
					y++;
				}
			}
			
/*	REMOVE v1.0 */						System.out.println("In EndOfGameController. commited junkpile " + junkpile.getJunkPile().size());

			Iterator<CardCombos> cc = refcc.iterator();
			int x = 0;
			while(cc.hasNext()) {
/*	REMOVE v1.0 */						System.out.println("DEBUG! Committing refcc transactions");
				em.getTransaction().begin();
/*	REMOVE v1.0 */						System.out.println("DEBUG! Committing refcc transactions after commit");
				em.merge(cc.next());
				em.getTransaction().commit();
				cc.remove();
				x++;
			}
/*	REMOVE v1.0 */						System.out.println("In EndOfGameController. commited refcc " + refcc.size());	

			em.getTransaction().begin();
			em.merge(players.getLocalPlayer());								//	Commit all changes to LocalPlayer back to DB
			em.getTransaction().commit();
//			em.close();
/*	REMOVE v1.0 */						System.out.println("In EndOfGameController. commited LocalPlayer " + players.getLocalPlayer().toString());

/*			gameResults.setTimestamp();
			em.getTransaction().begin();									//	Create new gameResults to DB
	REMOVE v1.0 						System.out.println("In EndOfGameController. commited GameResults " + gameResults.toString());
			em.persist(gameResults);
			em.getTransaction().commit();
			em.close();
			emf.close();*/
/*	REMOVE v1.0 */						System.out.println("In EndOfGameController. committed GameResults " + gameResults.toString());
//		}
//		catch(Exception e) {
//			System.out.println("EndofGameController exception: " + e);
//		}
		
		session.invalidate();
		return new ModelAndView("index");
	}
}
