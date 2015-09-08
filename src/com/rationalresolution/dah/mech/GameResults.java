package com.rationalresolution.dah.mech;

import javax.persistence.*;
import java.sql.Timestamp;;


@Table(name = "GameResults")
public class GameResults {
	//	Fields
	
	@Column(name = "grPKey")
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int grPKey;
	
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
	
	@Column(name = "grTimeStamp")
	@Temporal(TemporalType.TIMESTAMP)
	private Timestamp timestamp;

	//	Constructor
	public GameResults() {
		// set gameID to new PKey value
	}
	
	//	Accessor Methods
	public int getGrPKey()				{ return grPKey;			}
	public int getLocalPlayer1Score()	{ return localPlayer1Score;	}
	public int getBlinkyScore()			{ return blinkyScore;		}
	public int getPinkyScore()			{ return pinkyScore;		}
	public int getInkyScore()			{ return inkyScore;			}
	public int getClydeScore()			{ return clydeScore;		}
	
	public void setGrPKey()				{}				//	NEED PROCESS FOR AUTOMATED ID GENERATION
	public void setLocalPlayer1Score()	{ localPlayer1Score++;		}
	public void setBlinkyScore()		{ blinkyScore++;			}
	public void setPinkyScore()			{ pinkyScore++;				}
	public void setInkyScore()			{ inkyScore++;				}
	public void setClydeScore()			{ clydeScore++;				}
	
	//	Methods
	
}
