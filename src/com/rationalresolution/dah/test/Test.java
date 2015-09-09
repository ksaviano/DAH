package com.rationalresolution.dah.test;

import javax.persistence.*;

import com.rationalresolution.dah.cards.*;
import com.rationalresolution.dah.players.*;

public class Test {
	private static EntityManagerFactory emf = null;
	private static EntityManager em = null;
	
	public static void main(String[] args) {
		System.out.println("Testing DAH");
		
		try {
			emf = Persistence.createEntityManagerFactory("DAH");
			em = emf.createEntityManager();
			
			System.out.println("\nPlayer Query");
			PlayVWin testdb = em.find(PlayVWin.class, 1);
			System.out.println(testdb.getDealt());
			
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
}
