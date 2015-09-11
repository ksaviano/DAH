package com.rationalresolution.dah.spring;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.rationalresolution.dah.players.*;

@Controller
@SessionAttributes
@RequestMapping("/NewPlayer")
public class NewPlayerController {

	@RequestMapping(method=RequestMethod.POST)
	public ModelAndView onSubmit(@RequestParam("username") String u, @RequestParam("password") String p) {
		ModelAndView mv = new ModelAndView("profile");
		EntityManagerFactory emf;
		EntityManager em;
		emf = Persistence.createEntityManagerFactory("DAH");
		em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		//	DEBUG!!!
		System.out.println("DEBUG! In NewPlayerController.java");
		try {
			et.begin();
			LocalPlayer newplayer = new LocalPlayer(u, p);			
			LocalPlayer results = findPlayer2(u, p);
			
			if(results == null) {
				mv.addObject("playerobject", newplayer);
				em.persist(newplayer);
				et.commit();
				System.out.println("Added new player to database.");
				return mv;
			}
			else {
				String errorMsg = "Username already exists. Please login or change username.";
				System.out.println(errorMsg);
						return new ModelAndView("NewPlayer", "error", errorMsg);
			}
		}
		catch(Exception e) {
			String errorMsg ="Error in NewPlayerController\n" + e;
			System.out.println(errorMsg);
			return new ModelAndView("NewPlayer", "error", errorMsg); 
		}
		
	}
	
	public LocalPlayer findPlayer2(String u, String p) {
		EntityManagerFactory emf;
		EntityManager em;
		emf = Persistence.createEntityManagerFactory("DAH");
		em = emf.createEntityManager();
		
		return (LocalPlayer) em.createQuery("SELECT p from LocalPlayer p WHERE p.username = :user").setParameter("user", u).getSingleResult();
	}
}
