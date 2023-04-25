package com.cts.iocdemo.views;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.cts.iocdemo.services.GreetService;

@Component
public class HomeView {
	
	@Autowired
	@Qualifier("greetServiceSimpleImpl")
	private GreetService greetService1;
	
	@Autowired
	@Qualifier("greetServiceTimeBasedImpl")
	private GreetService greetService2;

	public void run() {
		System.out.println("Welcome To Spring Enabled Application!");
		
		String userName="Vamsy";
		System.out.println(greetService1.greetUser(userName));
		System.out.println(greetService2.greetUser(userName));
	}
}
