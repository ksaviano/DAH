package com.rationalresolution.dah.players;

import com.rationalresolution.dah.players.GhostPlayer.Ghosts;

public class Players {
	//	Fields
	private Player[] players = new Player[5];
	private static int round = 0;
	
	//	Constructor
	public Players() {
		System.out.println("In players class constructor");
		setGhostPlayers();
	}
	
	//	Accessor Methods
	public Player[] getPlayers()	{ return players;		}
	public int getRound()			{ return round;			}
	public LocalPlayer getLocalPlayer()	{ return (LocalPlayer) players[0];	}
	public GhostPlayer getGhostPlayer(int i) { return (GhostPlayer) players[i]; }
	
	public void setRound()				 	{ round++;			}
	public void setLocalPlayer(Player p)	{ players[0] = p;	}
	public void setGhostPlayers()		 	{ players[1] = new GhostPlayer(Ghosts.BLINKY);
											  players[2] = new GhostPlayer(Ghosts.PINKY);
											  players[3] = new GhostPlayer(Ghosts.INKY);
											  players[4] = new GhostPlayer(Ghosts.CLYDE); }
	
	
	
	public String toString() {
		return "Players:\t" + players[0].toString() + "\t" + players[1].toString() + "\t" + players[2].toString() + "\t" + players[3].toString() + "\t" + players[4].toString();
	}
}
