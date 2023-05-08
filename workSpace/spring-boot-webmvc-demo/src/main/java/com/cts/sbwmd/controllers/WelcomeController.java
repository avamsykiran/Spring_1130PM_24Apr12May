package com.cts.sbwmd.controllers;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class WelcomeController {

	/*
	 * http://localhost:9999
	 * http://localhost:9999/
	 * http://localhost:9999/home
	 * 
	 * if 9999 is the configured port number for tomcat web server
	 * */
	
	@GetMapping({"","/","/home"})
	public ModelAndView homePageAction( @RequestParam(name="unm",required = false) String userName ) {
		String msg=null;
		if(userName!=null) {
			msg = "Hello " + userName;
		}
		return new ModelAndView("home","message",msg);
	}
	
	@RequestMapping("/header")
	public ModelAndView getHeaderAction() {
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("header");
		mv.addObject("appTitle", "HR Portal");
		mv.addObject("today", LocalDate.now().format(DateTimeFormatter.ofPattern("dd-MMMM-yyyy")));
		
		return mv;
	}
	
	@RequestMapping("/footer")
	public ModelAndView getFooterAction() {
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("footer");
		mv.addObject("team", new String[] {"Vamsy","Kalab","Sharmilie","Keerthy"});
		
		return mv;
	}
}
