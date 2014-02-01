package com.dima.algorithms;

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
		PrimeNumber pr = new PrimeNumber();
		
		System.out.println(pr.isPrime1(4));
		
	}

}
