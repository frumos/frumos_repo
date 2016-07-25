package year2016.org.dima.algorithms.numeric;

import java.util.Arrays;
import java.util.stream.Collectors;

public class BinaryAddition {

	private static final char _1 = '1';

	public String addition(String s1, String s2) {
		int length = 0;
		int s1Length = s1.length();
		int s2Length = s2.length();
		
		if (s1Length > s2Length) {
			length = s1Length + 1;
		} else {
			length = s2Length + 1;
		}

		boolean[] b1_arr = binaryStringToBoolean(length, s1);
		boolean[] b2_arr = binaryStringToBoolean(length, s2);
		Boolean[] result = new Boolean[length];

		boolean flip = false;

		for (int i = 1; i < length; i++) {
			boolean b1 = b1_arr[length - i];
			boolean b2 = b2_arr[length - i];
			boolean add = b1 ^ b2 ^ flip;
			flip = (b1 & b2) ^ (b1 & flip) ^ (b2 & flip);
			result[length - i] = add;
		}
		result[0] = flip;
		
		return booleanToBinaryStr(result);
		
	}
	
	private boolean[] binaryStringToBoolean(int length, String str) {
		boolean[] b_arr = new boolean[length];
		int strLength = str.length();
		char[] ch_arr = str.toCharArray();
		
		for (int i = 1; i <= strLength; i++) {
			char ch = ch_arr[strLength - i];
			b_arr[length - i] = getBit(ch);
		}
		return b_arr;		
	}

	
	private String booleanToBinaryStr(Boolean[] arr) {
		return Arrays.stream(arr).map(e -> {
			if (e) {
				return "1";
			} else {
				return "0";
			}
		}).collect(Collectors.joining(""));
	}
	

	public boolean getBit(char ch) {
		if (ch == _1) {
			return true;
		} else {
			return false;
		}
	}
	
}
