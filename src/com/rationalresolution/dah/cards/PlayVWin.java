package com.rationalresolution.dah.cards;

import javax.persistence.*;


@Table(name = "PlayVWin")
public class PlayVWin {
	//	Fields
	@Column(name = "pvwPKey")
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int pvwPKey;
	
	@Column(name = "pvwDealt")
	private int dealt								= 0;
	
	@Column(name = "pvwPlayed")
	private int played								= 0;
	
	@Column(name = "pvwWon")
	private int won									= 0;
	
	//	Constructor
	public PlayVWin() {
		
	}
	
	//	Accessor Methods
	public int getPvwPKey()	{ return pvwPKey;	}
	public int getDealt()	{ return dealt;		}
	public int getPlayed()	{ return played;	}
	public int getWon()		{ return won;		}
	
	public void setPvwPKey()	{}						//	NEED AUTO GENERATED ID PROCESS
	public void setDealt()	{ dealt++;			}
	public void setPlayed()	{ played++;			}
	public void setWon()	{ won++;			}
	
}
