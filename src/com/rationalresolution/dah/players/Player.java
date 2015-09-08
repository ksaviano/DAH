package com.rationalresolution.dah.players;

import javax.persistence.*;

import com.rationalresolution.dah.cards.WhiteCard;


@Table(name = "Player")
public abstract class Player {
	//	Fields
	
	@Column(name = "plPKey")
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int plPKey;
	
	@Column(name = "plUsername")
	private String username;
	
	@Column(name = "plProfile")
	@OneToOne
	@JoinColumn(name = "ppPKey")
	private PlayerProfile profile 					= new PlayerProfile();
	
	@Column(name = "plHand")
	protected WhiteCard[] hand 						= new WhiteCard[7];
	
	//	Constructor
	public Player() {
		
	}
	
	public Player(String u) {
		setUsername(u);
	}
	
	//	Accessor Methods
	public int getPlayerID()			{ return plPKey;			}
	public String getUsername()			{ return username;			}
	public WhiteCard[] getHand()		{ return hand;				}
	
	public void setPlPKey(int id)		{ }								//	need QA no duplicate work on ID
	public void setUsername(String u)	{ username = u; }				//	need QA no duplicate work on username
	public void setHand(WhiteCard wc, int a) { hand[a] = wc;		}
	
	
	//	Methods
	public abstract int decideCard();
	public WhiteCard playCard(int x) {			//	ROUND OF PLAY STEP 3
		WhiteCard playedCard = hand[x];
		hand[x] = null;
		return playedCard;
	}
}
