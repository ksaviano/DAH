package com.rationalresolution.dah.players;

import com.rationalresolution.dah.players.GhostPlayer.Ghosts;

public class Players {
	//	Fields
	private Player[] players = new Player[5];
	private String[] avatars = new String[5];
	private int[] points = new int[5];
	private static int round = 1;
	
	//	Constructor
	public Players() {
		System.out.println("In players class constructor");
		setGhostPlayers();
		
	}
	
	//	Accessor Methods
	public Player[] getPlayers()	{ return players;		}
	public int getRound()			{ return round;			}
	public LocalPlayer getLocalPlayer()	{ return (LocalPlayer) players[0];	}
	public Player getGhostPlayer(int i) { 
		if(i == 0) {
			return (LocalPlayer) players[i];
		}
		else {
			return (GhostPlayer) players[i]; 
		}
	}
	public int getPoints(int x)		{
		return points[x];
	}
	
	public void setRound()				 	{ round++;			}
	public void setLocalPlayer(Player p)	{ players[0] = p;	}
	public void setGhostPlayers()		 	{ players[1] = new GhostPlayer(Ghosts.BLINKY);
											  players[2] = new GhostPlayer(Ghosts.PINKY);
											  players[3] = new GhostPlayer(Ghosts.INKY);
											  players[4] = new GhostPlayer(Ghosts.CLYDE); 
											  System.out.println("DEBUG... Players setGhostPlayers(): ghost players are set up now");}
	public void setPoints(int x)			{ points[x] += 10;	}
	public void setAvatars()				{ avatars[0] = getLocalPlayer().getAvatar();
											  avatars[1] = "/DAH/images/avatars/Blinky.png";
											  avatars[2] = "/DAH/images/avatars/Pinky.png";
											  avatars[3] = "/DAH/images/avatars/Inky.png";
											  avatars[4] = "/DAH/images/avatars/Clyde.png"; }
	public String getAvatars(int x)			{ return avatars[x]; }
	
	
	
	public String toString() {
		return "Players:\t" + players[0].toString() + "\t" + players[1].toString() + "\t" + players[2].toString() + "\t" + players[3].toString() + "\t" + players[4].toString();
	}
}
