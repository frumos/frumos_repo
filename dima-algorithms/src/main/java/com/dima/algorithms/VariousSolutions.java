package com.dima.algorithms;

public class VariousSolutions {

public boolean hasStringDuplicates(String s ) {
		
		boolean[] duplicates = new boolean[256];
		
		for(int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if(duplicates[c]) {
				return true;
			} else {
				duplicates[c] = true;
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		VariousSolutions v = new VariousSolutions();
		System.out.println(v.hasStringDuplicates("abcdfl"));
		
		System.out.println(v.hasStringDuplicates("abcdffgdfl"));
		

	}

}
