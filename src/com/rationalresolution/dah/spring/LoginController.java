package com.rationalresolution.dah.spring;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.rationalresolution.dah.players.*;

@Controller
@SessionAttributes
@RequestMapping("/login")
public class LoginController {

	@RequestMapping(method=RequestMethod.POST)
	public ModelAndView onSubmit(@RequestParam("username") String u, @RequestParam("password") String p) {
		ModelAndView mv = new ModelAndView("profile");
		LocalPlayer player = new LocalPlayer(u, p);
		PlayerManager pm = new PlayerManager();
		
		//	DEBUG!
		System.out.println("DEBUG! In LoginController.java");
		
		if(pm.getPlayer(player) != null) {
			mv.addObject("userDto", player);
			return mv;
		}
		else {
			String errorMsg = "Username/password combination not found.";
			return new ModelAndView("index", "error", errorMsg);
		}
		
	}
	
}
