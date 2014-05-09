package com.dima.algorithms;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class PrimeNumber {

	
	
	public boolean isPrime1(int n) {
		if(n <= 2) return false;
		
		if(n%2==0) return false;
		if(n%3==0) return false;
		
		for (int i=3; i<n; i+=2){
			if(n%i==0) return false;
		}
		return true;
	}
	
	
	
	
	
	public static void main(String[] args) {
	
		String a = new String("aaa");
		String b = new String("aaa");
		
		System.out.println(a==b);
		
		
		Set<String> set = new HashSet<String>();
		
		
		set.add(new String("dima"));
		set.add(new String("dima"));
		
		System.out.println(set.size());
		
		
		
	}

}
