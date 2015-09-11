package com.rationalresolution.dah.spring;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.rationalresolution.dah.players.LocalPlayer;

public class PlayerManager implements UserDAO {
	//	Fields
	
	
	
	//	Methods
	public LocalPlayer getPlayer(LocalPlayer p) {
		EntityManagerFactory emf;
		EntityManager em;
		emf = Persistence.createEntityManagerFactory("DAH");
		em = emf.createEntityManager();
		
		if(playerExists(p) == false) {
			return new LocalPlayer();
		}
		
//		if(p.getUsername().equals(em.find(LocalPlayer.class,  p).getUsername()) && p.getPassword().equals(onlyPlayer.getPassword())) {
//			return onlyPlayer;
//		}
		return null;
	}
	
	public boolean playerExists(LocalPlayer p) {
		EntityManagerFactory emf;
		EntityManager em;
		emf = Persistence.createEntityManagerFactory("DAH");
		em = emf.createEntityManager();
		
		if(em.find(LocalPlayer.class, p) != null) {
			return true;
		}
		return false;
	}
	
	public void getPlayerinDB(LocalPlayer p) {

		
//		if(p == em.find(LocalPlayer.class, p)) {
			
//		}
	}
}
