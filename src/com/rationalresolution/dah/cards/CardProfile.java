package com.rationalresolution.dah.cards;

import java.util.HashMap;
import java.util.Map;
import javax.persistence.*;


@Table(name = "CARDPROFILE")
public class CardProfile {
	//	Fields
	@Column(name = "cpPKey")
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int cpPKey;
	
	@Column(name = "cpCardSet")
	private eCardSet cardSet 						= eCardSet.OR;
	
	
	private Map<String, Integer> cardDescVotes		= new HashMap<>();
	
	
	private Map<String, Integer> cardRatings		= new HashMap<>();
	
	//	Enum
	public enum eCardSet { OR, E1, E2, E3, E4, E5, E6, E7, E8, E9, PS };	// OR = original deck, E# = Expansion Pack #, PS = Player Submitted

	//	Constructor
	public CardProfile() {
		cardDescVotes.put("gross", 0);
		cardDescVotes.put("inapprop", 0);
		cardDescVotes.put("funny", 0);
		cardDescVotes.put("dontknow", 0);
		for(int i = 0; i < 10; i++) 			{ cardRatings.put(("" + i), 0);		}
	}
	
	//	Accessor Methods
	public int getCp_ID()						{ return cpPKey;										}
	public eCardSet getCardSet()				{ return cardSet;									}
	public Integer getCardDescVotes(String s)	{ return cardDescVotes.get(s);						}
	public int getCardRating() {
		int average = 0;
		for(int i = 0; i < 10; i++) {
			average += (cardRatings.get(("" + i)) * i);
		}
		return (average / 10);	
	}
	
	public void setCpPKey()						{ }					//	Need automatic assignment of cpPKey
	public void setCardSet(eCardSet e)			{ cardSet = e;										}
	public void setCardDescVotes(String s) {
		if(cardDescVotes.containsKey(s)) {
			cardDescVotes.put(s, (cardDescVotes.get(s) + 1));
		}
		else {
			cardDescVotes.put(s, 1);
		}
	}
	public void setCardRatings(String s) {
		if(cardRatings.containsKey(s)) {
			cardRatings.put(s, (cardRatings.get(s)   + 1)); 
		}
		else {
			cardRatings.put(s, 1);
		}
	}
	
	//	Methods
	
	
}
