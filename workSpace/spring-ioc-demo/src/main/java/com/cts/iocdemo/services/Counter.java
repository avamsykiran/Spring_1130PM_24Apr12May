package com.cts.iocdemo.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service
@Scope("prototype")
public class Counter {

	@Value("${app.seed}")
	private int count;
	
	public int nextCount() {
		return ++count;
	}
}
