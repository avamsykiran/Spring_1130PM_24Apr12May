package com.cts.iocdemo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.cts.iocdemo.views.HomeView;

public class IoCDemoApplication {

	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(BeanConfig.class);
		
		HomeView view = (HomeView) context.getBean("homeView");
		view.run();

	}

}
