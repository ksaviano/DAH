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
	
	public CardCombos(int wcFKey, int bcFKey) {
		try {
			EntityManagerFactory emf;
			EntityManager em;
			
			emf = Persistence.createEntityManagerFactory("DAH");
			em = emf.createEntityManager();
			
			String qString = "SELECT c FROM CardCombos c WHERE c.wcFKey = :wcKey AND c.bcFKey = :bcKey";
			Query query = em.createQuery(qString).setParameter("wcKey", ccwcFKey).setParameter("bcKey", ccbcFKey);
			List<CardCombos> elementList = query.getResultList();
			
			if(elementList.isEmpty()) {
				setCcwcFKey(wcFKey);
				setCcbcFKey(bcFKey);
				setCount();
			}
			else {
				
			}
			//	if(combo is already in CardCombos) { setCount()) }
			//	else {

			//	}
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
	public void setCcwcFKey(int wcKey)	{ ccwcFKey = wcKey;		}
	public void setCcbcFKey(int bcKey)	{ ccbcFKey = bcKey;		}
	
	//	Methods
	
}