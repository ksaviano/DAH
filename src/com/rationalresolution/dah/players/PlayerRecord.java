package com.rationalresolution.dah.players;

public class PlayerRecord {
	//	Fields
	int gamesPlayed;
	int handsWon;
	int horriblePoints;
	
	//  Constructor
	public PlayerRecord(int gp, int hw, int hp) {
		setGamesPlayed(gp);
		setHandsWon(hw);
		setHorriblePoints(hp);
	}
	
	//	Accessor Methods
	public int getGamesPlayed()				{ return gamesPlayed;		}
	public int getHandsWon()				{ return handsWon;			}
	public int getHorriblePoints()			{ return horriblePoints;	}
	
	public void setGamesPlayed(int gp)		{ gamesPlayed = gp;			}
	public void setHandsWon(int hw)			{ handsWon = hw;			}
	public void setHorriblePoints(int hp)	{ horriblePoints = hp;		}
}
