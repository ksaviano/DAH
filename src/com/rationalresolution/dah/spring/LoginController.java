package com.rationalresolution.dah.spring;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.rationalresolution.dah.players.*;

@Controller
@SessionAttributes(value={"player"})
@RequestMapping("/login")
public class LoginController {
	//	Fields
	
	//	Constructor
	
	//	Methods
	@ModelAttribute("player")
	public LocalPlayer setPlayerModel() {
		return new LocalPlayer();
		
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ModelAndView onSubmit(@RequestParam("username") String u, @RequestParam("password") String p, @ModelAttribute("player") LocalPlayer incplayer) {
		incplayer.setUsername(u);
		incplayer.setPassword(p);
		
		if(findPlayer(u, p) == null) {
			String errorMsg = "Username/password combination not found.";
			return new ModelAndView("index", "error", errorMsg);
		}
		else {
			ModelAndView mv = new ModelAndView("profile");
			mv.addObject("playerPlayed", 0);
			mv.addObject("playerHandsWon", 0);
			return mv;
		}
	}
	
	public LocalPlayer findPlayer(String u, String p) {
		EntityManagerFactory emf;
		EntityManager em;
		emf = Persistence.createEntityManagerFactory("DAH");
		em = emf.createEntityManager();
		
		LocalPlayer temp = (LocalPlayer) em.createQuery("SELECT p from LocalPlayer p WHERE p.username = :user").setParameter("user", u).getSingleResult();
		if(temp != null) {
			return temp;
		}
		else {													//	FIGURE OUT WHAT TO DO WITH NULL RETURN
			System.out.println("username not found.");
			return new LocalPlayer();
		}
	}
}