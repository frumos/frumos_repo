package com.dima.aop;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("appConfig.xml");
		
		SomePspBusinessProcess bm = ctx.getBean(SomePspBusinessProcess.class);
		
		List<String> l = new ArrayList<String>();
		l.add("sonera");
		l.add("dna");
		
		System.out.println(bm.pspBusinessMethos("dna", l));
		System.out.println(bm.pspBusinessMethos("dna", l));
		System.out.println(bm.pspBusinessMethos("dna", l));
		System.out.println(bm.pspBusinessMethos("dna", l));
		System.out.println(bm.pspBusinessMethos("dna", l));
		System.out.println(bm.pspBusinessMethos("dna", l));
		System.out.println(bm.pspBusinessMethos("dna", l));
		System.out.println(bm.pspBusinessMethos("dna", l));
		System.out.println(bm.pspBusinessMethos("dna", l));
		System.out.println(bm.pspBusinessMethos("dna", l));
		System.out.println(bm.pspBusinessMethos("dna", l));
		System.out.println(bm.pspBusinessMethos("dna", l));
		System.out.println(bm.pspBusinessMethos("dna", l));
		System.out.println(bm.pspBusinessMethos("dna", l));
		System.out.println(bm.pspBusinessMethos("dna", l));

	}

}
