//package com.rationalresolution.dah.spring;
//
//import javax.persistence.EntityManager;
//import javax.persistence.EntityManagerFactory;
//import javax.persistence.EntityTransaction;
//import javax.persistence.Persistence;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpSession;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.bind.annotation.SessionAttributes;
//import org.springframework.web.bind.support.SessionStatus;
//import org.springframework.web.servlet.ModelAndView;
//
//import com.rationalresolution.dah.players.*;
//
//// 	THIS CLASS CAN BE DESTROYED!
//
//
//@Controller
//public class LoginController {
//
//	//	Methods
//	@RequestMapping(path="Login", method=RequestMethod.POST)
//	@ResponseBody
//	public LocalPlayer  onSubmit(@RequestParam("username") String u, 
//								 @RequestParam("password") String p, 
//								 HttpSession session) {
//		LocalPlayer incplayer = findPlayer(u, p);
//		System.out.println("DEBUG... LoginController.java @RequestMapping Login findPlayer(u, p)");
//		if(incplayer == null) {									//	loops page until it gets correct username/password
//			String errorMsg = "Username/password combination not found.";
//			return incplayer;
//		}
//		else {
//			session.setAttribute("localPlayer", incplayer);		//	throws localPlayer into session 
//			return incplayer;									
//		}
//	}
//	
//	@RequestMapping(path="NewPlayer", method=RequestMethod.POST)
//	public LocalPlayer onNewPlayerSubmit(@RequestParam("newplayername") String u, 
//								 		  @RequestParam("newplayerpass") String p,
//								 		  @RequestParam("nickname") String n,
//								 		  @RequestParam("avatar") String a,
//								 		  HttpSession session) {
//		System.out.println("DEBUG! In NewPlayerController.java");
//		LocalPlayer newplayer;
//			newplayer = new LocalPlayer(u, p, n, a);
//
//		
//		try {
//			EntityManagerFactory emf;
//			EntityManager em;
//			emf = Persistence.createEntityManagerFactory("DAH");
//			em = emf.createEntityManager();
//			EntityTransaction et = em.getTransaction();
//
//			et.begin();		
//				em.persist(newplayer);
//				et.commit();
//				System.out.println("Added new player to database.");
//			}
//		catch(Exception e) {
//			String errorMsg ="Error in NewPlayerController\n" + e;
//			System.out.println(errorMsg);
//		}
//		
//		return newplayer;
//	}
//	
//	public LocalPlayer findPlayer(String u, String p) {
//		EntityManagerFactory emf;
//		EntityManager em;
//		emf = Persistence.createEntityManagerFactory("DAH");
//		em = emf.createEntityManager();
//		
//		LocalPlayer temp = (LocalPlayer) em.createQuery("SELECT p from LocalPlayer p WHERE p.username = :user AND p.password = :pass").setParameter("user", u).setParameter("pass", p).getSingleResult();
//		if(temp != null) {
//			return temp;										//	returns localPlayer to main method
//		}
//		else {													//	FIGURE OUT WHAT TO DO WITH NULL RETURN
//			System.out.println("username not found.");
//			return new LocalPlayer();
//		}
//	}
//}