package com.cts.sbd.views;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.cts.sbd.services.Counter;
import com.cts.sbd.services.GreetService;

@Component
public class HomeView implements CommandLineRunner{
	
	@Value("${app.name}")
	private String appName;
	
	@Autowired
	@Qualifier("greetServiceSimpleImpl")
	private GreetService greetService1;
	
	@Autowired
	@Qualifier("greetServiceTimeBasedImpl")
	private GreetService greetService2;

	@Autowired
	private Scanner kbin;
	
	@Autowired
	private Counter c1;
	
	@Autowired
	private Counter c2;
	
	@Autowired
	private Counter c3;

	@Override
	public void run(String... args) throws Exception {
		System.out.println(appName);
		System.out.println("--------------------------------------------------");
		
		System.out.println("User Name? ");
		String userName=kbin.next();
		System.out.println(greetService1.greetUser(userName));
		System.out.println(greetService2.greetUser(userName));
		
		System.out.println(c1.nextCount());
		System.out.println(c2.nextCount());
		System.out.println(c3.nextCount());
		
	}
}
