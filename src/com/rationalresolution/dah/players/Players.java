package com.rationalresolution.dah.players;

import com.rationalresolution.dah.players.GhostPlayer.Ghosts;

public class Players {
	//	Fields
	Player[] players = new Player[5];
	int round = 0;
	
	//	Constructor
	public Players() {
		
	}
	
	//	Accessor Methods
	public Player[] getPlayers()	{ return players;		}
	public int getRound()			{ return round;			}
	public Player getLocalPlayer()	{ return players[0];	}
	
	public void setRound()				 	{ round++;			}
	public void setLocalPlayer(Player p)	{ players[0] = p;	}
	public void setGhostPlayers()		 	{ players[1] = new GhostPlayer(Ghosts.BLINKY);
											  players[2] = new GhostPlayer(Ghosts.PINKY);
											  players[3] = new GhostPlayer(Ghosts.INKY);
											  players[4] = new GhostPlayer(Ghosts.CLYDE); }
	
	
	
}
