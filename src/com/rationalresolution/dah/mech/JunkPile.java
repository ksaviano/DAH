package com.rationalresolution.dah.mech;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.rationalresolution.dah.cards.WhiteCard;
import com.rationalresolution.dah.players.*;

public class JunkPile {
	//	Fields
	private static ArrayList<WhiteCard> junkPile = new ArrayList<>(GameDeck.WCCOUNT);
	private static int arraySpot = 0;
	
	//	Constructor
	public JunkPile() {
		System.out.println("in JunkPile class constructor");
	}
	
	public static WhiteCard getJunkPile(int i)			{ return junkPile.get(i);	}
	public static void setJunkPile(WhiteCard wc) {
		wc.setPlayed();
		arraySpot++;
		junkPile.add(arraySpot, wc);
	}
	
	public static void discardRemainingHands(Players players) {
		for (Player player : players.getPlayers()) {
			WhiteCard[] tempCard = player.getHand();
			for(int i = 0; i < 7; i++) {
				if(tempCard[i] != null) {
					player.discard(i);
				}
			}
		}
	}
	
	public void sendStatstoDB(LocalPlayer player) {
		EntityManagerFactory emf = null;
		EntityManager em = null;
		emf = Persistence.createEntityManagerFactory("DAH");
		em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		et.begin();
		for (WhiteCard whiteCard : junkPile) {
			em.merge(whiteCard);
		}
		em.merge(player);
		et.commit();
	}
}
