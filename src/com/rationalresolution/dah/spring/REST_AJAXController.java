package com.rationalresolution.dah.spring;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.rationalresolution.dah.cards.BlackCard;
import com.rationalresolution.dah.cards.WhiteCard;
import com.rationalresolution.dah.mech.GameDeck;
import com.rationalresolution.dah.players.LocalPlayer;
import com.rationalresolution.dah.players.Players;

@Controller
public class REST_AJAXController {

	@RequestMapping(path="REST/getRoundNum", method=RequestMethod.GET)
	@ResponseBody
	public int getRoundNum(HttpSession session) {
		GameDeck deck 		= (GameDeck)	session.getAttribute("deck");
		return deck.getRoundnum();

	}
	
	@RequestMapping("REST/dispBlackCard")
	@ResponseBody
	public BlackCard dispBlackCardJSON(HttpSession session) {
		GameDeck deck 		= (GameDeck)	session.getAttribute("deck");
		return deck.dispCurrentBC();
	}

	@RequestMapping("REST/getPlayerHand")
	@ResponseBody
	public WhiteCard[] getPlayerHandJSON(HttpSession session) {
		Players players 	= (Players) 	session.getAttribute("players");
		System.out.println("in /getPlayerHand: " + players.getLocalPlayer().getNickname());
		return players.getLocalPlayer().getHand();
	}
	
	@RequestMapping("REST/getRoundPlays")
	@ResponseBody
	public WhiteCard[] getRoundPlays(HttpSession session) {
		Players players		= (Players)		session.getAttribute("players");
		System.out.println("in /getRoundPlays: " + players.getLocalPlayer().getRoundpick().toString());
		WhiteCard[] roundPlays = new WhiteCard[5];
		roundPlays[0] = players.getLocalPlayer().getRoundpick();
		for(int i = 1; i < players.getPlayers().length; i++) {
			roundPlays[i] = players.getPlayers()[i].getRoundpick();
		}
		return roundPlays;
	}
	
	@RequestMapping("REST/getRoundWinner")
	@ResponseBody
	public WhiteCard getRoundWinner(HttpSession session) {
		GameDeck deck 		= (GameDeck)	session.getAttribute("deck");
		return deck.getRoundWinner();
	}
	
	@RequestMapping("REST/checkUsername")
	@ResponseBody
	public boolean checkUsername(@RequestParam("username") String u) {
		EntityManagerFactory emf;
		EntityManager em;
		emf = Persistence.createEntityManagerFactory("DAH");
		em = emf.createEntityManager();
		
		LocalPlayer temp = (LocalPlayer) em.createQuery("SELECT p from LocalPlayer p WHERE p.username = :user").setParameter("user", u).getSingleResult();
		if(temp == null) {
			System.out.println("username not found in database. Avaialble for new player.");
			return false;
		}
		else {
			System.out.println("username found in database. Not avaialble for new player.");
			return true;
		}
	}
}