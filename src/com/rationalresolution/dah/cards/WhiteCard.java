package com.rationalresolution.dah.cards;

import java.util.HashMap;
import java.util.Map;
import javax.persistence.*;


@Table(name = "WhiteCard")
public class WhiteCard extends Card {
	//	Fields
	
	@Column(name = "wcPKey")
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int wcPKey;
	
	@Column(name = "wccbFKey")														//	1:1 relationship with parent class Card
	@JoinColumn(name = "cbPKey")
	private int wccbFKey 							= getCardID();
	
	@Column(name = "wcWins")
	private int wins 								= 0;
	
	@Column(name = "wcPlayed")
	private int played 								= 0;
	
	@Column(name = "wcCombos")
	@ManyToOne
	@JoinColumn(name = "bcPKey")
	private Map<String, Integer> combos				= new HashMap<>();				//	wcbcFKey (black card ID of played combos, PlayVWin)
	
	@Column(name = "wcStats")
	@OneToOne
	@JoinColumn(name = "plwPKey")
	private PlayVWin stats 							= new PlayVWin();
	
	//	Constructor
	public WhiteCard(int id, String text) {
		super(id, text);
		setReadAloud(defTextToVoice(text));
	}
	
	//	Accessor Methods
	public int getWcPKey()					{ return wcPKey;	}
	public int getWins()					{ return wins;		}
	public int getPlayed()					{ return played;	}
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
	
	@Override
	public void setCardText(String text) {
		//	ensure no duplicates in DB
	}
	
	//	Methods
	@Override
	public void setReadAloud() {			//	if no parameter, use default method to make sound file
		String text = getCardText();
		setReadAloud(defTextToVoice(text));
	}
	
	@Override
	public String defTextToVoice(String text) {
		// api to text-to-voice service
		return "DEFAULT";
	}
	
	
}
