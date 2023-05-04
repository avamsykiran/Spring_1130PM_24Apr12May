package com.cts.sbwmd.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

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
	public String homePageAction() {
		return "home";
	}
}
