package com.cts.sbd.services;

import org.springframework.stereotype.Service;

@Service
public class GreetServiceSimpleImpl implements GreetService {

	public String greetUser(String userName) {
		return "Hello " + userName;
	}

}
