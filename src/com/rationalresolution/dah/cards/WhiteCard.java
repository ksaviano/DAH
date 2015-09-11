package com.rationalresolution.dah.cards;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.persistence.*;

import com.rationalresolution.dah.mech.UtilReadAloud;

@Entity
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
	
	@Column(name = "wcDealt")
	private int dealt								= 0;

//	private ArrayList<String> readAloud				= new ArrayList<>();
//	private CardProfile profile						= new CardProfile();

//	private Map<String, Integer> combos				= new HashMap<>();				//	wcbcFKey (black card ID of played combos, PlayVWin)
	

//	private PlayVWin stats 							= new PlayVWin();
	
	//	Constructor
	public WhiteCard() {
		
	}
	
	public WhiteCard(String text) {
		setCardText(text);
//		UtilReadAloud.setReadAloud(text);
		wins = 0;
		played = 0;
//		commitNewCardtoDB(text);
	}
	
	//	Accessor Methods
	public int getcardID()					{ return cardID;	}
	public int getWins()					{ return wins;		}
	public int getPlayed()					{ return played;	}
	public String getCardText()				{ return cardText;	}
	public int getDealt()					{ return dealt;		}
//	public Map<String, Integer> getCombos()	{ return combos;	}

	public void setCardID()					{ cardID = 1348;	}
	public void setCardText(String t)		{ cardText = t;		}
	public void setWins()					{ wins++;			}
	public void setPlayed()					{ played++;			}
	public void setDealt()					{ dealt++;			}
//	public void setCombos(String bcFKey) {
//		if(combos.containsKey(bcFKey)) {
//			combos.put(bcFKey, (combos.get(bcFKey) + 1));
//		}
//		else {
//			combos.put(bcFKey, 1);	
//		}
//	}
	

	
	//	Methods
	public void commitNewCardtoDB(String text) {
		EntityManagerFactory emf = null;
		EntityManager em = null;
		emf = Persistence.createEntityManagerFactory("DAH");
		em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		try {
			et.begin();
			System.out.println("Genertating new card...");
			em.persist(new WhiteCard(text));
			et.commit();
			System.out.println("New card added to database.");
		}
		catch(Exception e) {
			System.out.println("Error in commitWhiteCard. Card not added." + e);
		}
	}
}
