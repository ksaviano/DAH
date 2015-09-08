package com.rationalresolution.dah.cards;

import java.util.ArrayList;
import javax.persistence.*;


@Table(name = "Card")
public abstract class Card {
	//	Fields
	
	@Column(name = "cbPKey")
	@Id									
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int cardID 						= 0;					//	Primary Key whatever
	
	@Column(name = "cbCardText")		
	private String cardText 				= "Insert text here";
	
	@Column(name = "cbReadAloud")		
	private ArrayList<String> readAloud		= new ArrayList<>();
	
	@Column(name = "cbProfile")
	@OneToOne
	@JoinColumn(name = "cpPKey")
	private CardProfile profile 			= new CardProfile();
	
	@Column(name = "cbFavorited")
	private int favorited 					= 0;
	
	@Column(name = "cbDealt")
	private int dealt  						= 0;
	
	//	Constructors
	public Card() {
		
	}
	
	public Card(int id, String text) {
		setCardID(id);
		setCardText(text);
		setReadAloud();
	}
	
	//	Accessor Methods
	public int getCardID()					{ return cardID;		}
	public String getCardText()				{ return cardText;		}
	public ArrayList<String> getReadAloud()	{ return readAloud;		}
	public int getFavorited()				{ return favorited;		}
	public int getDealt()					{ return dealt;			}
	public CardProfile getCardProfile()		{ return profile;		}
	
	public void setCardID(int id)			{ } 									// ensure no duplicates				
	public abstract void setCardText(String text);
	public void setReadAloud(String s)		{ readAloud.add(s);		}
	public void setFavorited()				{ favorited++;			}
	public void setDealt()					{ dealt++;				}
	
	//	Methods
	public abstract void setReadAloud();
	public abstract String defTextToVoice(String text);
	
	public void doReadAloud() {			
		for (String text : readAloud) {
			//	play each sound file in order
		}
	}
}
