package com.rationalresolution.dah.spring;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import com.rationalresolution.dah.players.*;

@Controller
public class LoginController {

	//	Methods
	@RequestMapping(path="Login", method=RequestMethod.POST)
	public ModelAndView onSubmit(@RequestParam("username") String u, 
								 @RequestParam("password") String p, 
								 HttpSession session) {
		LocalPlayer incplayer = findPlayer(u, p);
		if(incplayer == null) {									//	loops page until it gets correct username/password
			String errorMsg = "Username/password combination not found.";
			return new ModelAndView("index", "error", errorMsg);
		}
		else {
			session.setAttribute("localPlayer", incplayer);		//	throws localPlayer into session 
			return new ModelAndView("profile");					//	forwards to profile.jsp
		}
	}
	
/*	@RequestMapping(path="NewPlayer", method=RequestMethod.POST)
	public ModelAndView onNewPlayerSubmit(@RequestParam("username") String u, 
								 		  @RequestParam("password") String p,
								 		  HttpSession session) {
		ModelAndView mv = new ModelAndView("profile");

		if(findPlayer(u)) {
			String errorMsg = "That username is already taken. Click 'Return to Login Screen' to login with password or choose a different username.";
			return new ModelAndView("newplayer", "error", errorMsg);
		}
		else {
			
		}
		System.out.println("DEBUG! In NewPlayerController.java");
		try {
			et.begin();
			LocalPlayer newplayer = new LocalPlayer(u, p);			
				em.persist(newplayer);
				et.commit();
				System.out.println("Added new player to database.");
				return mv;
			}
		catch(Exception e) {
			String errorMsg ="Error in NewPlayerController\n" + e;
			System.out.println(errorMsg);
			return new ModelAndView("NewPlayer", "error", errorMsg); 
		}
	}*/
	
	public LocalPlayer findPlayer(String u, String p) {
		EntityManagerFactory emf;
		EntityManager em;
		emf = Persistence.createEntityManagerFactory("DAH");
		em = emf.createEntityManager();
		
		LocalPlayer temp = (LocalPlayer) em.createQuery("SELECT p from LocalPlayer p WHERE p.username = :user AND p.password = :pass").setParameter("user", u).setParameter("pass", p).getSingleResult();
		if(temp != null) {
			return temp;										//	returns localPlayer to main method
		}
		else {													//	FIGURE OUT WHAT TO DO WITH NULL RETURN
			System.out.println("username not found.");
			return new LocalPlayer();
		}
	}
	
	public boolean findPlayer(String u) {
		EntityManagerFactory emf;
		EntityManager em;
		emf = Persistence.createEntityManagerFactory("DAH");
		em = emf.createEntityManager();
		
		LocalPlayer temp = (LocalPlayer) em.createQuery("SELECT p from LocalPlayer p WHERE p.username = :user").setParameter("user", u).getSingleResult();
		if(temp == null) {
			System.out.println("username not found in database. Avaialble for new player.");
			return false;
		}
		else {
			System.out.println("username found in database. Not avaialble for new player.");
			return true;
		}

	}
}