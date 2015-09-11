package com.rationalresolution.dah.players;

import javax.persistence.*;

@Entity
@Table(name = "PLAYERPROFILE")
public class PlayerProfile {
	//	Fields
	
	@Column(name = "ppPkey")
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int ppPKey;
	
	@Column(name = "PPNickname")
	private String nickname							= "Asshat";
	
	@Column(name = "ppAvatar")
	private String avatar							= "DefaultAvatar.jpg";
	
	@Column(name = "ppGamesPlayed")
	private int gamesPlayed 						= 0;
	
	@Column(name = "ppHandsWon")
	private int handsWon 							= 0;
	
	@Column(name = "ppHorriblePoints")
	private int horriblePoints 						= 0;					//	later social point system implementation
	
	//	Constructor
	public PlayerProfile() {
		
	}
	
	public PlayerProfile(String a) {
		setAvatar(a);
	}
	
	//	Accessor Methods
	public int getPpPKey()				{ return ppPKey;			}
	public String getNickname()			{ return nickname;			}
	public String getAvatar()			{ return avatar;			}
	public int getGamesPlayed()			{ return gamesPlayed;		}
	public int getHandsWon()			{ return handsWon;			}
	public int getHorriblePoints()		{ return horriblePoints;	}
	
	public void setNickname(String n)	{ nickname = n;				}
	public void setAvatar(String a)		{ avatar = a;				}
	public void setGamesPlayed()		{ gamesPlayed++;			}
	public void setHandsWon()			{ handsWon++;				}
	public void setHorriblePoints(int h)	{ horriblePoints += h;	}
}
