package com.dima;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:app-config-withoutDB.xml"})
public class Test1 {
	
	@Test
	public void testOne(){
		System.out.println("ONE");
	}
	

}
