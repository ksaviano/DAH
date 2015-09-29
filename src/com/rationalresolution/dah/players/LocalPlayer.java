package com.rationalresolution.dah.players;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.rationalresolution.dah.cards.WhiteCard;
import com.rationalresolution.dah.mech.JunkPile;

@Entity
@Table(name = "LOCALPLAYER")
public class LocalPlayer implements Player {
	//	Fields
	
	@Column(name = "lpPKey")
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int playerID;
	
	@Column(name = "LPUSERNAME")
	private String username				=	"Heath Beaver";
	
	@Column(name = "lpPassword")
	private String password				=	"password";
	
	@Column(name = "lpNickname")
	private String nickname				=	"asshat";
	
	@Column(name = "lpAvatar")
	private String avatar				=	"/images/avatars/defaultavatar.jpg";
	
	@Column(name = "lpGamesPlayed")
	private int gamesPlayed				=	0;
	
	@Column(name = "lpHandsWon")
	private int handsWon				=	0;
	
	@Column(name = "lpHorriblePoints")
	private int horriblePoints			=	0;

	@Transient
	public WhiteCard[] hand				= new WhiteCard[7];		//	does not need to be stored in DB
	
	//	Constructor
	public LocalPlayer() {

	}
	
	public LocalPlayer(String u, String p) {
		setUsername(u);
		setPassword(p);
	}
	
	public LocalPlayer(String u, String p, String n, String a) {
		this(u, p);
		setNickname(n);
		setAvatar(a);
	}
	
	//	Accessor Methods
	public int getPlayerID()			{ return playerID;			}
	public String getUsername()			{ return username;			}
	public String getPassword()			{ return password;			}
	public String getNickname()			{ return nickname;			}
	public String getAvatar()			{ return avatar;			}
	public int getGamesPlayed()			{ return gamesPlayed;		}
	public int getHandsWon()			{ return handsWon;			}
	public int getHorriblePoints()		{ return horriblePoints;	}
	public WhiteCard[] getHand()		{ return hand;				}		//	returns array of cards in hand (0-6)
	
	public void setUsername(String u)			{ username = u;		}
	public void setPassword(String p)			{ password = p; 	}
	public void setNickname(String n)			{ nickname = n;		}
	public void setAvatar(String a)				{ avatar = a;		}
	public void setGamesPlayed()				{ gamesPlayed++;	}
	public void setHandsWon()					{ handsWon++;		}
	public void setHorriblePoints(int x)		{ horriblePoints+=x;}
	public void setHand(WhiteCard wc, int a)	{ hand[a] = wc;		}		//	puts whitecard into hand at array index a (0-6)
	
	
	//	Methods
	public int decideCard() {						//	ROUND OF PLAY STEP 2
		//	not used for localPlayer- here so Player Interface can have method so players.decideCard() can work for ghosts
		int x = 0;									// this will be returned from ChooseCard.jsp
		return x;
	}
	
	public WhiteCard playCard(int x) {				//	ROUND OF PLAY STEP 3
		WhiteCard playedCard = hand[x];				//	x is passed from choosecard.jsp as the selected card (0-6)
		JunkPile.setJunkPile(playedCard);			//	the card is sent to the junkpile
		playedCard.setPlayed();						//	the cards' played number is increased by 1
		hand[x] = null;								//	the array spot where the card was is set to null (used by DealCards.dealNextRound to populate with new card from whitedeck)
		return playedCard;							//	returns the playedCard
	}

	public void discard(int x) {					//	At end of game, discard all remaining cards to junkpile (loop in EndofGameController.java)
		WhiteCard discardedCard = hand[x];			//	call passes array index of card to be discarded
		JunkPile.setJunkPile(discardedCard);		//	card is sent to the junkpile (note that the card's played field is NOT increased)
		hand[x] = null;								//	remove ref to card from player's hand.
	}
	
	public String toString() {
		return username;
	}
	
}
