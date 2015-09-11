package com.rationalresolution.dah.mech;

import com.rationalresolution.dah.players.*;

//	DESTROY THIS CLASS!

public class GamePlay {
	//	Fields
	private int gameID;										//	gpgrFKey
	private Player[] players 	= new Player[5];
	private LocalPlayer player;
	private GhostPlayer blinky	= new GhostPlayer();
	private GhostPlayer pinky	= new GhostPlayer();
	private GhostPlayer inky	= new GhostPlayer();
	private GhostPlayer clyde	= new GhostPlayer();
	private int round			= 0;
	
	
	
	//	Constructor
	GameDeck game = new GameDeck();
	
	//	Accessor Methods
	public GhostPlayer getBlinky()		{ return blinky;	}
	public GhostPlayer getPinky()		{ return pinky;		}
	public GhostPlayer getInky()		{ return inky;		}
	public GhostPlayer getClyde()		{ return clyde;		}
	public LocalPlayer getPlayer()		{ return player;	}
	public Player[] getPlayers()		{ return players;	}
	
	public void setPlayer(int id)		{ }						//	Figure out how to return player object
	
	
	//	Methods
	public Player[] populatePlayers() {
		players[0] = getPlayer();
		players[1] = getBlinky();
		players[2] = getPinky();
		players[3] = getInky();
		players[4] = getClyde();
		return players;
	}
	
	
	
	
}
