package com.rationalresolution.dah.spring;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.rationalresolution.dah.players.LocalPlayer;

@Controller
@RequestMapping("/OLDNewPlayer")
public class NewPlayerController {
}
	//	Methods
/*	@RequestMapping(method=RequestMethod.POST)
	public ModelAndView onSubmit(@RequestParam("username") String u, 
								 @RequestParam("password") String p,
								 HttpSession session) {
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
	}
}*/
