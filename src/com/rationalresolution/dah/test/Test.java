package com.rationalresolution.dah.test;

import java.util.ArrayList;
import java.util.Stack;

import javax.persistence.*;

import com.rationalresolution.dah.cards.*;
import com.rationalresolution.dah.mech.GameDeck;
import com.rationalresolution.dah.players.*;

public class Test {
	private static EntityManagerFactory emf = null;
	private static EntityManager em = null;
	
	public static void main(String[] args) {
		System.out.println("Testing DAH");
		
		try {
			emf = Persistence.createEntityManagerFactory("DAH");
			em = emf.createEntityManager();
			
//			System.out.println("\nPlayer Query");
//			PlayVWin testdb = em.find(PlayVWin.class, 1);
//			System.out.println(testdb.getDealt());
//			EntityTransaction et = em.getTransaction();
//			try {
//				et.begin();
//				System.out.println("start transaction");
//				em.persist(new WhiteCard("Flying sex snakes"));
//				et.commit();
//				System.out.println("wrote to database... I think!");
//			}
//			catch(Exception e) {
//				System.out.println("Error in commitWhiteCard" + e);
//			}
//			WhiteCard wc = new WhiteCard("Test Text");
//			wc.setCardID();
//			usePreparedSQLtoCommit(wc);
		}			
		catch(Exception e) {
			System.out.println(e);
		}
	}
	
	public static void commitWhiteCard(WhiteCard wc) {
		EntityTransaction et = em.getTransaction();
		try {
			et.begin();
			WhiteCard writeWhiteCard = new WhiteCard(wc.getCardText());
			em.persist(writeWhiteCard);
			et.commit();
		}
		catch(Exception e) {
			System.out.println("Error in commitWhiteCard" + e);
		}
	}
	
	public static void endGame(ArrayList<WhiteCard> junkpile) {
		
		for (WhiteCard card : junkpile) {
			
		}
	}
}
