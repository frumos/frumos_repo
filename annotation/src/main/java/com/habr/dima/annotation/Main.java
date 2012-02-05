package com.habr.dima.annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	public static void main(String[] args) {		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("appConfig.xml");		
		OldModelBasedOnWebService service = ctx.getBean(OldModelBasedOnWebService.class);		
		System.out.println(service.createSubscription("Sonera"));
	}
}
