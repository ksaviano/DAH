package com.rationalresolution.dah.cards;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.*;

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

	@Transient
	private ArrayList<String> readAloud				= new ArrayList<>();

	@Column(name = "wcEdition")
	private String edition							= "orig";
	
	@Column(name = "wcPG13")
	private int pg13								= 0;
	
	@Column(name = "wcXXX")
	private int xxx									= 0;
	
	@Column(name = "wcDunno")
	private int dunno								= 0;
	
	@Column(name = "wcGross")
	private int gross								= 0;
	
	@Column(name = "wcInapprop")
	private int inapprop							= 0;
	
	
	
	//	Constructor
	public WhiteCard() {
		
	}
	
	public WhiteCard(String text) {
		setCardText(text);
		wins = 0;
		played = 0;
	}
	
	//	Accessor Methods
	public int getcardID()					{ return cardID;	}
	public String getCardText()				{ return cardText;	}
	public int getWins()					{ return wins;		}
	public int getPlayed()					{ return played;	}
	public int getDealt()					{ return dealt;		}
	public String getEdition()				{ return edition;	}
	public int getPg13()					{ return pg13;		}
	public int getXxx()						{ return xxx;		}
	public int getDunno()					{ return dunno;		}
	public int getGross()					{ return gross;		}
	public int getInapprop()				{ return inapprop;	}

//	public void setCardID()					{ /* automatically set by DB */ }
	public void setCardText(String t)		{ cardText = t;		}
	public void setWins()					{ wins++;			}
	public void setPlayed()					{ played++;			}
	public void setDealt()					{ dealt++;			}
	public void setEdition(String e)		{ edition = e;		}
	public void setPg13()					{ pg13++;			}
	public void setXxx()					{ xxx++;			}
	public void setDunno()					{ dunno++;			}
	public void setGross()					{ gross++;			}
	public void setInapprop()				{ inapprop++;		}

	
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
	
	public String toString() {
		return getCardText();
	}
}
