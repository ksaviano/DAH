package com.rationalresolution.dah.mech;

import com.rationalresolution.dah.players.Players;

public class GamesScores {
	//	Fields
	Players players;
	GameResults gameresults;
	
	//	Constructor
	public GamesScores() {
		
	}
	
	public GamesScores(Players p, GameResults g) {
		setPlayers(p);
		setGameResults(g);
	}
	
	//	Methods
	public Players getPlayers() 				{ return players; }
	public GameResults getGameresults()			{ return gameresults; }
	
	public void setPlayers(Players p)			{ players = p; }
	public void setGameResults(GameResults g)	{ gameresults = g; }
}
