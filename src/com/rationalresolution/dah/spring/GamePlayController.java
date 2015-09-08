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
@RequestMapping("/Game")
public class GamePlayController {

	@RequestMapping(method=RequestMethod.POST)
	public ModelAndView onSubmit() {
		ModelAndView mv = new ModelAndView("choosecard");
		
		//	DEBUG!
		System.out.println("DEBUG! In GamePlayController.java");
		
		return mv;
	}
}
