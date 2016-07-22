package year2016.org.dima.algorithms.numeric;

import java.util.Arrays;

public class BinaryAddition {
		
	private static final char _0 = '0';
	
	private static final char _1 = '1';
		
	public void addition(String s1, String s2) {
		int length = 0;
		int s1Length = s1.length();
		int s2Length = s2.length();
		
		char[] ch1 = s1.toCharArray();
		char[] ch2 = s2.toCharArray();
		
		System.out.println(Arrays.toString(ch1));
		System.out.println(Arrays.toString(ch2));
				
		if (s1Length > s2Length) {
			length = s1Length + 1;
		} else {
			length = s2Length + 1;
		}
				
		boolean[] b1 = new boolean[length];
		boolean[] b2 = new boolean[length];
		boolean[] buffer = new boolean[length];
		boolean[] result = new boolean[length];
		
		for(int i = 1; i <= s1Length; i++) {
			char ch = ch1[s1Length - i];			
			b1[length - i] = getBit(ch);			
		}
		
		for(int i = 1; i <= s2Length; i++) {
			char ch = ch2[s2Length - i];
			b2[length - i] = getBit(ch);
		}
		
		
		for(int i = 1; i < length; i++) {
			boolean add = b1[length - i] ^ b2[length - i] ^ buffer[length - i];
			boolean buf = !add;
			result[length - i] = add;
			buffer[length - i - 1] = buf;
		}
		
		result[0] = buffer[0];
		
		System.out.println("buf = " + Arrays.toString(buffer));
		
		System.out.println("st1 = " + Arrays.toString(b1));
		System.out.println("st2 = " + Arrays.toString(b2));
		
		System.out.println("res = " + Arrays.toString(result));
		
		
		
	}
	
	public boolean getBit(char ch) {
		if (ch == _1) {			
			return true;			
		} else {			
			return false;
		}			
	}
	
	
	public static void main(String[] args) {
		BinaryAddition ba = new BinaryAddition();
				
		ba.addition("000111001", "1101");
	}

}
