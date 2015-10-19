package com.rationalresolution.dah.cards;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.Table;

@Entity
@Table(name = "CARDCOMBOS")
public class CardCombos {
	//Fields
	@Column(name = "ccPKey")
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int comboID;
	
	@Column(name = "ccCount")
	private int count					= 0;
	
	@Column(name = "ccwcFKey")
	// @ManyToMany
	private int ccwcFKey				= 0;
	
	@Column(name = "ccbcFKey")
	// @ManyToMany
	private int ccbcFKey 				= 0;
	
	//	Constructor
	public CardCombos() {
		
	}
	
	public CardCombos(String wcFKey, String bcFKey) {
		this(Integer.parseInt(wcFKey), Integer.parseInt(bcFKey));
	}
	
	
	public CardCombos(int wcFKey, int bcFKey) {
		try {
			EntityManagerFactory emf;
			EntityManager em;
			
			emf = Persistence.createEntityManagerFactory("DAH");
			em = emf.createEntityManager();
			
			String qString = "SELECT c FROM CardCombos c WHERE c.ccwcFKey = :wcKey AND c.ccbcFKey = :bcKey";
			Query query = em.createQuery(qString).setParameter("wcKey", wcFKey).setParameter("bcKey", bcFKey);
			List<CardCombos> elementList = query.getResultList();
			
			if(elementList.isEmpty()) {									//	DB Call will either bring in card combo but if new, this populates fields)
				setCcwcFKey(wcFKey);
				setCcbcFKey(bcFKey);
				setCount();
			}
			else {														//	If card combo exists... need to add to refcc and increase count
				
			}
		} catch (Exception e) {
			System.out.println("DEBUG! In CardCombos constructor with error: " + e);
		}
	}
	
	//	Accessor Methods
	public int getComboID()				{ return comboID;		}
	public int getCount()				{ return count;			}
	public int getCcwcFKey()			{ return ccwcFKey;		}
	public int getCcbcFKey()			{ return ccbcFKey;		}
	
	public void setCount()				{ count++;				}
	public void setCount(int prevcount)	{ count += prevcount;	}
	public void setCcwcFKey(int wcFKey)	{ ccwcFKey = wcFKey;		}
	public void setCcbcFKey(int bcKey)	{ ccbcFKey = bcKey;		}
	
	//	Methods
	
}
