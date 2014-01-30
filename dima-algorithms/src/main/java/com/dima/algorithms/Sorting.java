package com.dima.algorithms;

public class Sorting {

	String txt = "evaluate is used to create new evaluation subscriptions the"
			+ "call will fail if sebe determines that creation of an evaluation subscription" +
			" hat you might be making an assumption that for each array specifying the initial values at compile-time";
	
	
	public void sortTest() {
		String[] txtArray = txt.split(" ");		
		byte[][] byteArray = new byte[txtArray.length][];
		for (int i = 0; i < byteArray.length; i++) {
			byteArray[i] = txtArray[i].getBytes();
		}
				
		long start = System.currentTimeMillis();
		for (int k = byteArray.length; k >= 0; k--) {
			
			for (int i = 0; i < k - 1; i++) {
				byte[] currentToken = byteArray[i];
				byte[] nextToken = byteArray[i + 1];
				int length = currentToken.length <= nextToken.length ? currentToken.length
						: nextToken.length;
				for (int j = 0; j < length; j++) {
					if (currentToken[j] > nextToken[j]) {
						// do swap						
						byte[] tmp = byteArray[i];
						byteArray[i] = byteArray[i + 1];
						byteArray[i + 1] = tmp;
						
						break;
					} else if (currentToken[j] == nextToken[j]) {
						continue;
					} else {
						break;
					}
				}
			}			
		}
		
		long end = System.currentTimeMillis();
		System.out.println("Time " + (end - start));

		for(int i = 0; i < byteArray.length; i++){
			System.out.print(" ");
			System.out.print(new String(byteArray[i]));
		}		
		
	}
	
	public void arrayBubbleSort() {
		int intArr[] = { 12, 4, 2, 6, 5, 7, 10, 10, 3, 44, 13, 1, 3, 9 };

		for (int j = intArr.length; j >= 0; j--) {
			for (int i = 0; i < j - 1; i++) {
				if (intArr[i] < intArr[i + 1]) {
					int tmp = intArr[i];
					intArr[i] = intArr[i + 1];
					intArr[i + 1] = tmp;
				}
			}
		}	
	}

	public static void main(String[] args) {
		Sorting sorting = new Sorting();		
		sorting.sortTest();
		System.out.println("");		
	}

}
