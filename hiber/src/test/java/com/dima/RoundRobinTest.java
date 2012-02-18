package com.dima;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.dima.readyimpl.RoundRobin;

public class RoundRobinTest {
	
	RoundRobin rr; 
	
	@Before
	public void before(){
		List<String> l = new ArrayList<String>();
		l.add("slave1");
		l.add("slave2");
		l.add("slave3");
		rr = new RoundRobin(l);
	}
	
	
	class MyThread implements Runnable{
		public void run() {			
			for (int i = 0; i < 200; i++) {				
//				RoundRobin.getNextKey();				
				System.out.println("ThreadId: " 
						+ Thread.currentThread().getId() 
						+ " " + RoundRobin.getNextSlave());
			}		
		}	
	}
	
	@Test
	public void testRoundeRobin(){	
		long s =  System.currentTimeMillis();
		
		Thread t1 = new Thread(new MyThread());
		Thread t2 = new Thread(new MyThread());
		Thread t3 = new Thread(new MyThread());
		Thread t4 = new Thread(new MyThread());
		
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		
		try {
			t1.join();
			t2.join();
			t3.join();
			t4.join();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		long e =  System.currentTimeMillis();
		System.out.println("Time iter: " + (e-s));
		
	}
	
	
}
