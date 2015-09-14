package com.rationalresolution.dah.players;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.rationalresolution.dah.cards.WhiteCard;

@Entity
@Table(name = "LOCALPLAYER")
public class LocalPlayer implements Player {
	//	Fields
	
	@Column(name = "lpPKey")
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int playerID;
	
	@Column(name = "LPUSERNAME")
	private String username;
	
	@Column(name = "lpPassword")
	private String password;
	
//	private PlayerProfile profile				= new PlayerProfile();

	@Transient
	public WhiteCard[] hand						= new WhiteCard[7];
	
	//	Constructor
	public LocalPlayer() {
		setUsername("Heath Beaver");
		setPassword("password");
	}
	
	public LocalPlayer(String u, String p) {
		setUsername(u);
		setPassword(p);
	}
	
	//	Accessor Methods
	public int getPlayerID()			{ return playerID;			}
	public String getUsername()			{ return username;			}
	public String getPassword()			{ return password;			}
	public WhiteCard[] getHand()		{ return hand;		}
	
	public void setUsername(String u)			{ username = u;		}
	public void setPassword(String p)			{ password = p; 	}					//	I think there is some password automation avail
	public void setHand(WhiteCard wc, int a)	{ hand[a] = wc;		}
	
	
	//	Methods
	public int decideCard() {						//	ROUND OF PLAY STEP 2
		//	not used - here so Player Interface can have method so players.decideCard() can work for ghosts
		int x = 0;									// this will be return from ChooseCard.jsp
		return x;
	}
	
	public WhiteCard playCard(int x) {				//	ROUND OF PLAY STEP 3
//		WhiteCard playedCard = hand[x];
//		JunkPile.setJunkPile(playedCard);
//		playedCard.setPlayed();
//		hand[x] = null;
		WhiteCard playedCard = new WhiteCard();
		return playedCard;
	}

	public void discard(int x) {
//		WhiteCard discardedCard = hand[x];
//		JunkPile.setJunkPile(discardedCard);
//		hand[x] = null;
	}
	
	public String toString() {
		return username;
	}
	
}
