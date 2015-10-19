package com.rationalresolution.dah.mech;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;;

@Entity
@Table(name = "GameResults")
public class GameResults {
	//	Fields
	
	@Column(name = "grPKey")
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int grPKey;
	
	@Column(name = "grlpFKey")
	private int localPlayerID;
	
	@Column(name = "grLocalPlayer1Score")
	private int localPlayer1Score 					= 0;
	
	@Column(name = "grBlinkyScore")
	private int blinkyScore 						= 0;
	
	@Column(name = "grPinkyScore")
	private int pinkyScore  						= 0;
	
	@Column(name = "grInkyScore")
	private int inkyScore   						= 0;
	
	@Column(name = "grClydeScore")
	private int clydeScore  						= 0;
	
//	@Column(name = "grTimeStamp")
//	@Temporal(TemporalType.TIMESTAMP)
//	private Timestamp timestamp;
	
	//	Constructor
	public GameResults() {
		// set gameID to new PKey value
		System.out.println("DEBUG... in GameResults.java Constructor");
	}
	
	//	Accessor Methods
	public int getGrPKey()				{ return grPKey;			}
	public int getLocalPlayerID()		{ return localPlayerID;		}
	public int getLocalPlayer1Score()	{ return localPlayer1Score;	}
	public int getBlinkyScore()			{ return blinkyScore;		}
	public int getPinkyScore()			{ return pinkyScore;		}
	public int getInkyScore()			{ return inkyScore;			}
	public int getClydeScore()			{ return clydeScore;		}
//	public Timestamp getTimestamp()		{ return timestamp;			}
	
	public void setLocalPlayerID(int i)			{ localPlayerID = i;			}
	public void setLocalPlayer1Score(int s)		{ localPlayer1Score = s;		}
	public void setBlinkyScore(int s)			{ blinkyScore = s;				}
	public void setPinkyScore(int s)			{ pinkyScore = s;				}
	public void setInkyScore(int s)				{ inkyScore = s;				}
	public void setClydeScore(int s)			{ clydeScore = s;				}
//	public void setTimestamp()					{ timestamp = new Timestamp(new java.util.Date().getTime());			}
	
	//	Methods
	public String toString() {
		return "Game Results:\tPlayer:\t" + getLocalPlayer1Score() + "\tBlinky:\t" + getBlinkyScore() + "\tPinky:\t" + getPinkyScore() + "\tInky:\t" + getInkyScore() + "\tClyde:\t" + getClydeScore();
	}
	
}
