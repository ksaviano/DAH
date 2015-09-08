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
@RequestMapping("/NewPlayer")
public class NewPlayerController {

	@RequestMapping(method=RequestMethod.POST)
	public ModelAndView onSubmit(@RequestParam("username") String u, @RequestParam("password") String p) {
		ModelAndView mv = new ModelAndView("profile");
		LocalPlayer newplayer = new LocalPlayer(u, p);
		PlayerManager pm = new PlayerManager();
		
		//	DEBUG!!!
		System.out.println("DEBUG! In NewPlayerController.java");
		
		if(pm.getPlayer(newplayer) == null) {
			//	Add new player to Local Player database!
			mv.addObject("userDto", newplayer);
			return mv;
		}
		else {
			String errorMsg = "Username already exists. Please login or change username.";
					return new ModelAndView("NewPlayer", "error", errorMsg);
		}
	}
}
