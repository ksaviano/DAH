package com.rationalresolution.dah.spring;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.rationalresolution.dah.cards.BlackCard;
import com.rationalresolution.dah.cards.CardCombos;
import com.rationalresolution.dah.cards.WhiteCard;
import com.rationalresolution.dah.mech.DealCards;
import com.rationalresolution.dah.mech.GameDeck;
import com.rationalresolution.dah.mech.GameResults;
import com.rationalresolution.dah.mech.GamesScores;
import com.rationalresolution.dah.mech.JunkPile;
import com.rationalresolution.dah.mech.WinnerDisplay;
import com.rationalresolution.dah.players.LocalPlayer;
import com.rationalresolution.dah.players.PlayerRecord;
import com.rationalresolution.dah.players.Players;

@Controller
public class REST_AJAXController {

	@RequestMapping("REST/getRoundNum")
	@ResponseBody
	public int getRoundNumJSON(HttpSession session) {
		GameDeck deck 		= (GameDeck)	session.getAttribute("deck");
		return deck.getRoundnum();
	}
	
	@RequestMapping("REST/dispBlackCard")
	@ResponseBody
	public BlackCard dispBlackCardJSON(HttpSession session) {
		System.out.println();
		GameDeck deck 		= (GameDeck)	session.getAttribute("deck");
		System.out.println("DEBUG... REST_AJAXController.java dispBlackCardJSON(session) deck: " + deck.dispCurrentBC());
		return deck.dispCurrentBC();
	}

	@RequestMapping("REST/getPlayerHand")
	@ResponseBody
	public WhiteCard[] getPlayerHandJSON(HttpSession session) {
		Players players 	= (Players) 	session.getAttribute("players");
		System.out.println("in /getPlayerHand: " + players.getLocalPlayer().getNickname());
		return players.getLocalPlayer().getHand();
	}
		
	@RequestMapping("/REST/getPlayerRecord")
	@ResponseBody
	public PlayerRecord getPlayerRecordJSON(HttpSession session) {
		LocalPlayer lp			= (LocalPlayer)		session.getAttribute("localPlayer");
		return new PlayerRecord(lp.getGamesPlayed(), lp.getHandsWon(), lp.getHorriblePoints());
	}
	
	@RequestMapping("REST/getRoundWinner")
	@ResponseBody
	public WhiteCard getRoundWinnerJSON(HttpSession session) {
		GameDeck deck 		= (GameDeck)	session.getAttribute("deck");
		return deck.getRoundWinner();
	}
	
	@RequestMapping("/REST/checkUsername")
	@ResponseBody
	public boolean checkUsernameJSON(@RequestParam("username") String u) {
		EntityManagerFactory emf;
		EntityManager em;
		emf = Persistence.createEntityManagerFactory("DAH");
		em = emf.createEntityManager();
		
		String qString = "SELECT p from LocalPlayer p WHERE p.username = :user";
		Query query = em.createQuery(qString).setParameter("user", u);
		List<LocalPlayer> elementList = query.getResultList();
		if(elementList.isEmpty()) {
			System.out.println("username not found in database. Avaialble for new player.");
			return false;
		}
		else {
			System.out.println("username found in database. Not avaialble for new player.");
			return true;
		}
	}
	
	@RequestMapping("/REST/login")
	@ResponseBody
	public LocalPlayer onLoginSubmit(@RequestParam("username") String u,
									 @RequestParam("password") String p,
									 HttpSession session) {
		EntityManagerFactory emf;
		EntityManager em;
		emf = Persistence.createEntityManagerFactory("DAH");
		em = emf.createEntityManager();
		boolean status = false;

		String qString = "SELECT p from LocalPlayer p WHERE p.username = :user AND p.password = :pass";
		Query query = em.createQuery(qString).setParameter("user", u).setParameter("pass", p);
		List<LocalPlayer> elementList = query.getResultList();
		if(elementList.isEmpty()) {
			System.out.println("username not found in database. Login FAILED.");
			status = false;
		}
		else {
			System.out.println("successful login.");
			status = true;
		}
		if(status == true) {
			LocalPlayer incplayer = elementList.get(0);
			session.setAttribute("localPlayer", incplayer);
			return incplayer;
		}
		else {
			return new LocalPlayer();
			//	need to add logic to calling code to dismiss this one.
		}
	}
	
	@RequestMapping(path="/REST/NewPlayer", method=RequestMethod.POST)
	@ResponseBody
	public LocalPlayer onNewPlayerSubmit(@RequestParam("username") String u, 
								 		 @RequestParam("password") String p,
								 		 @RequestParam("nickname") String n,
								 		 HttpSession session) {
		System.out.println("DEBUG! In NewPlayerController.java");
		LocalPlayer newplayer;
			newplayer = new LocalPlayer(u, p, n);
		
		try {
			EntityManagerFactory emf;
			EntityManager em;
			emf = Persistence.createEntityManagerFactory("DAH");
			em = emf.createEntityManager();
			EntityTransaction et = em.getTransaction();

			et.begin();		
				em.persist(newplayer);
				et.commit();
				System.out.println("Added new player to database.");
			}
		catch(Exception e) {
			String errorMsg ="Error in NewPlayerController\n" + e;
			System.out.println(errorMsg);
		}
		session.setAttribute("localPlayer", newplayer);
		return newplayer;
	}
	
	@RequestMapping(path="/REST/setPlayerChoice", method=RequestMethod.POST)
	@ResponseBody
	public WhiteCard[] onSelectCardFromHand(@RequestParam("playerchoice") String pc,
									 HttpSession session) {
		Players players 	= (Players) 	session.getAttribute("players");
		GameDeck deck		= (GameDeck)	session.getAttribute("deck");
		//	gets players from session
		WhiteCard[] playersChoices = new WhiteCard[5];
		int bc;
		
		for(int i = 0; i < players.getPlayers().length; i++) {
			if(i == 0) {
				bc = Integer.parseInt(pc.substring(pc.length()-1));
			}
			else {
				bc = deck.dispCurrentBC().getCardID();
			}
			playersChoices[i] = players.getPlayers()[i].playCard(players.getPlayers()[i].decideCard(bc, session));
		}
		
		session.setAttribute("playersChoices", playersChoices);
		return playersChoices;
	}
	
	@RequestMapping(path="/REST/selectWinner", method=RequestMethod.POST)
	@ResponseBody
	public WinnerDisplay onSelectWinner(@RequestParam("playerchoice") String pc,
							   @RequestParam("winningplayer") String wp,
							   HttpSession session) {
		Players players				= (Players)		session.getAttribute("players");
		WhiteCard[] playersChoices 	= (WhiteCard[])	session.getAttribute("playersChoices");
		GameDeck deck				= (GameDeck)	session.getAttribute("deck");
		GameResults gameResults		= (GameResults)	session.getAttribute("gameResults");
		ArrayList<CardCombos> refcc = (ArrayList<CardCombos>)	session.getAttribute("refcc");	//	get refcc from session
		
		int x = Integer.parseInt(wp.substring(wp.length()-1));
		if(x == 0) {
			players.getLocalPlayer().setHandsWon();
			players.getLocalPlayer().setHorriblePoints(10);
		}
		players.setPoints(x);
		deck.setRoundWinner(playersChoices[x]);
		playersChoices[x].setWins();
		
		gameResults.setLocalPlayer1Score(players.getPoints(0));						//	set points for players
		gameResults.setBlinkyScore(players.getPoints(1));
		gameResults.setPinkyScore(players.getPoints(2));
		gameResults.setInkyScore(players.getPoints(3));
		gameResults.setClydeScore(players.getPoints(4));
		
		CardCombos winningcomboforround = new CardCombos(deck.dispCurrentBC().getCardID(), deck.getRoundWinner().getcardID());		//	temp holder of card combo
		
		if(refcc.contains(winningcomboforround)) {									//	if card combo is in refcc, increase count 
			refcc.get(refcc.indexOf(winningcomboforround)).setCount();
		}
		else {
			refcc.add(winningcomboforround);										//	if new card combo, add to refcc
		}
		
		return new WinnerDisplay(players.getAvatars(x), deck.getRoundWinner(), x);
	}
	
	@RequestMapping(path="/REST/endRound", method=RequestMethod.POST)
	@ResponseBody
	public int onEndRound(HttpSession session) {
		GameDeck deck 		= (GameDeck)	session.getAttribute("deck");
		Players players 	= (Players) 	session.getAttribute("players");
		JunkPile junkpile	= (JunkPile)	session.getAttribute("junkpile");
		
		deck.setRoundnum();
System.out.println("DEBUG... in REST_AJAXController.java/REST/endRound. roundnum: " + deck.getRoundnum() + " totalRounds: " + GameDeck.getTotalRounds());
		if(deck.getRoundnum() <= GameDeck.getTotalRounds()) {
			DealCards.dealNextRound(players, deck, junkpile);
		}
		else {
System.out.println("DEBUG... in REST_AJAXController.java/REST/endRound. MISTAKE - got to last round without catch.");
		}
		return 1000;
	}
	
	@RequestMapping(path="/REST/getEndGameResults")
	@ResponseBody
	public GamesScores onShowScores(HttpSession session) {
		Players players 	= (Players) 	session.getAttribute("players");
		GameResults gameResults		= (GameResults)	session.getAttribute("gameResults");

		return new GamesScores(players, gameResults);
	}
	
}