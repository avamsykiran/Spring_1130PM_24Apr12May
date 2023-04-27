package com.cts.iocdemo;

import java.util.Scanner;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan("com.cts.iocdemo")
@PropertySource("classpath:application.properties")
public class BeanConfig {

	@Bean
	public Scanner scan() {
		return new Scanner(System.in);
	}
}
