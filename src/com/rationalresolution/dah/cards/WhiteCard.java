package com.rationalresolution.dah.cards;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.persistence.*;

import com.rationalresolution.dah.mech.UtilReadAloud;


@Table(name = "CARDWHITECARD")
public class WhiteCard {
	//	Fields
	
	@Column(name = "wcPKey")
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int cardID;
	
	@Column(name = "wcCardText")
	private String cardText							= "Insert Answer text here.";
	
	@Column(name = "wcWins")
	private int wins 								= 0;
	
	@Column(name = "wcPlayed")
	private int played 								= 0;

	private ArrayList<String> readAloud				= new ArrayList<>();
	private CardProfile profile						= new CardProfile();

	private Map<String, Integer> combos				= new HashMap<>();				//	wcbcFKey (black card ID of played combos, PlayVWin)
	

	private PlayVWin stats 							= new PlayVWin();
	
	//	Constructor
	public WhiteCard() {
		
	}
	
	public WhiteCard(int i, String text) {
		UtilReadAloud.setReadAloud(text);
	}
	
	//	Accessor Methods
	public int getcardID()					{ return cardID;	}
	public int getWins()					{ return wins;		}
	public int getPlayed()					{ return played;	}
	public String getCardText()				{ return cardText;	}
	public Map<String, Integer> getCombos()	{ return combos;	}
	
	public void setWcPKey()					{}						//	NEED AUTO GENERATED ID PROCESS
	public void setWins()					{ wins++;			}
	public void setPlayed()					{ played++;			}
	public void setCombos(String bcFKey) {
		if(combos.containsKey(bcFKey)) {
			combos.put(bcFKey, (combos.get(bcFKey) + 1));
		}
		else {
			combos.put(bcFKey, 1);	
		}
	}
	
	public void setCardText(String text) {
		//	ensure no duplicates in DB
		cardText = text;
	}
	
	//	Methods

	
}
