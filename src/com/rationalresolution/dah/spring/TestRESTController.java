//package com.rationalresolution.dah.spring;
//
//import java.util.ArrayList;
//
//import javax.servlet.http.HttpSession;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.servlet.ModelAndView;
//
//import com.rationalresolution.dah.cards.BlackCard;
//import com.rationalresolution.dah.cards.CardCombos;
//import com.rationalresolution.dah.cards.WhiteCard;
//import com.rationalresolution.dah.mech.DealCards;
//import com.rationalresolution.dah.mech.GameDeck;
//import com.rationalresolution.dah.mech.GameResults;
//import com.rationalresolution.dah.mech.JunkPile;
//import com.rationalresolution.dah.players.LocalPlayer;
//import com.rationalresolution.dah.players.Players;
//
//@Controller							//	picks up form action StartGame.html from profile.jsp
//public class TestRESTController {
//	
//	@RequestMapping(path="StartTestGame", method=RequestMethod.POST)
//	public ModelAndView onStartOfGame(HttpSession session) {
//		System.out.println("TestRESTController - line 1");
//		ModelAndView mv = new ModelAndView("playerhand-ajax");						//	send to choosecard.jsp
//		GameDeck.setTotalRounds(5);
////		LocalPlayer pl = (LocalPlayer) session.getAttribute("localPlayer");		//	pulls localPlayer from session (to be put into players class with ghosts)
//		
//		GameDeck deck 				= new GameDeck();							//	creation of a new deck sets a LOT into motion
//		JunkPile junkpile 			= new JunkPile();							//	junkpile is empty
//		Players players 			= new Players();							//	creates players class and "summons" 4 ghost players (array spots 1-4)
//		ArrayList<CardCombos> refcc	= deck.getRefcombos();						//	uses deck to bring all previous combos into ArrayList (will be used for updates)
//		GameResults gameResults 	= new GameResults();						//	used to hold results of game for DB
/////*	REMOVE v1.0 		System.out.println("DEBUG! In Start Game Controller.java\n" + pl.toString() );
//		
//		players.setLocalPlayer(new LocalPlayer("TestPlayer", "password", "tester", "/DAH/images/avatars/defaultavatar.png"));												//	adds the localPlayer to players (can remove localPlayer from session?)
//		players.setAvatars();
//		DealCards.dealStart(players, deck, junkpile);							//	pulls 7 white cards out of whitedeck for each player (7 * 5 = 35), sets dealt increase on cards
//		gameResults.setLocalPlayerID(players.getLocalPlayer().getPlayerID());							//	add LocalPlayer key to GameResults
//			
//		session.setAttribute("deck", deck);
//		session.setAttribute("junkpile", junkpile);
//		session.setAttribute("players", players);
//		session.setAttribute("refcc", refcc);
//		session.setAttribute("gameResults", gameResults);
//
//		return mv;
//	}
//
//	@RequestMapping("/getPlayerHand")
//	@ResponseBody
//	public WhiteCard[] getPlayerHandJSON(HttpSession session) {
//		Players players 	= (Players) 	session.getAttribute("players");
//		System.out.println("in /getPlayerHand: " + players.getLocalPlayer().getNickname());
//		return players.getLocalPlayer().getHand();
//	}
//	
//	@RequestMapping("/getBlackCard")
//	@ResponseBody
//	public BlackCard getBlackCardJSON(HttpSession session) {
//		GameDeck deck 		= (GameDeck)	session.getAttribute("deck");
//		return deck.getBlackCard();
//	}
//	
//	@RequestMapping(path="/getRoundNum", method=RequestMethod.GET)
//	@ResponseBody
//	public int getRoundNumJSON(HttpSession session) {
//		GameDeck deck 		= (GameDeck)	session.getAttribute("deck");
//		System.out.println("In getRoundNumJSON " + deck.getRoundnum());
//		return deck.getRoundnum();
//	}
///*	@RequestMapping("/getRoundNum")
//	@ResponseBody
//	public int getRoundNumJSON(HttpSession session) {
////		GameDeck deck 		= (GameDeck)	session.getAttribute("deck");
////		System.out.println("In getRoundNumJSON " + deck.getRoundnum());
//		return 3;
//	}
//*/
///*	@RequestMapping(path="/test", produces="application/json")
//	@ResponseBody
//	public LocalPlayer test() {
//		return new LocalPlayer();
//	}*/
//	
//}