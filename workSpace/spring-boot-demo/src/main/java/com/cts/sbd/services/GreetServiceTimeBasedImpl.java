package com.cts.sbd.services;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

@Service
public class GreetServiceTimeBasedImpl implements GreetService {

	public String greetUser(String userName) {
		String greeting="";
		
		int h = LocalDateTime.now().getHour();
		
		if(h>=3 && h<=11) greeting = "Good Morning";
		else if(h>11 && h<=16) greeting = "Good AfterNoon";
		else greeting="Good Evening";
		
		return greeting + " " + userName;
	}

}
