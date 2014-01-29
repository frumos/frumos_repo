package com.dima.algorithms;

/**
 * Code example at http://goo.gl/TorIW
 * 
 * @author lapka
 *
 */
public class ArrayStructures {
	
	private int[] theArray = new int[50];
	
	private int arraySize = 10;
	
	private void generateRandomArray() {
		for(int i=0; i<arraySize; i++) {
			theArray[i] = (int)(Math.random()*10) + 10;			
		}
	}
	
	private int getValueAtIndex(int index) {
		if(index < arraySize) {
			return theArray[index];
		} 
		return 0;
	}
	
	private boolean containValue(int value) {
		for (int i=0; i < arraySize; i++){
			if (theArray[i] == value) {
				return true;
			} 
		}
		return false;
	}
	
	public void deleteIndex(int index) {
		if(index < arraySize){			
			for(int i = index; i < arraySize - 1; i++){
				theArray[i] = theArray[i+1];				
			}
			arraySize--;
		}
	}
	
	
	
	
	
	
	
	private void insertValue(int value) {
		if(arraySize < 50){
			theArray[arraySize] = value;
			arraySize++;
		}
	}
	
	private String linearSearchForValue(int value) {
		boolean valueInArray = false;
		String indexesWithValue = "";
		System.out.println("The valuse were found: ");
		for(int i=0; i<arraySize; i++){
			if(theArray[i] == value) {
				valueInArray = true;
				indexesWithValue += i + " ";
			}
		}
		if(!valueInArray) {
			indexesWithValue = "None";
		}		
		return indexesWithValue;
		
	}
	
	public void bubbleSort(){
		for(int i=arraySize-1; i>0; i--) {
			for(int j=0; j<i; j++){
				if(theArray[j] > theArray[j + 1]) {
					swap(j, j+1);
					printHorzArray(i, j);
				}		
				printHorzArray(i, j);
			}	
		}		
	}
	
	public void binarySearch(int value){
		int lowIndex = 0;
		int highIndex = arraySize - 1;
		
		while(lowIndex <= highIndex) {
			int midleIndex = (highIndex + lowIndex) / 2;
		}
	}
	
	public void swap(int indexA, int indexB) {
		int tmp = theArray[indexA];
		theArray[indexA] = theArray[indexB];
		theArray[indexB] = tmp;	
	}
	
	
    public static void main( String[] args ) {
    	ArrayStructures arrayStructures = new ArrayStructures();
    	arrayStructures.generateRandomArray();
//    	arrayStructures.printArray();
//    	
//    	System.out.println(arrayStructures.getValueAtIndex(4));
//    	System.out.println(arrayStructures.containValue(15)); 
//    	
//    	arrayStructures.deleteIndex(4);
//    	arrayStructures.printArray();
//    	
//    	arrayStructures.insertValue(27);
//    	arrayStructures.printArray();
    	
    	
    	System.out.println(arrayStructures.linearSearchForValue(17));
    	
    	arrayStructures.printHorzArray(4, -1);
    	
    	
    	arrayStructures.bubbleSort();
    	
    	
    }
    
    
    private void printArray(){
		System.out.println("----------");
		for(int i = 0; i < arraySize; i++) {
			System.out.print("| " + i + " |");
			System.out.println(" " + theArray[i] + " |");			
		}		
		System.out.println("----------");
	} 
    
public void printHorzArray(int i, int j){
		
		for(int n = 0; n < 51; n++)System.out.print("-");		
		System.out.println();		
		for(int n = 0; n < arraySize; n++){			
			System.out.print("| " + n + "  ");			
		}
		
		System.out.println("|");		
		for(int n = 0; n < 51; n++)System.out.print("-");		
		System.out.println();		
		for(int n = 0; n < arraySize; n++){			
			System.out.print("| " + theArray[n] + " ");			
		}
		
		System.out.println("|");		
		for(int n = 0; n < 51; n++)System.out.print("-");		
		System.out.println();
		
		// END OF FIRST PART
		
		
		// ADDED FOR BUBBLE SORT
		
		if(j != -1){		
			// ADD THE +2 TO FIX SPACING			
			for(int k = 0; k < ((j*5)+2); k++)System.out.print(" ");			
			System.out.print(j);			
		}
		
		
		// THEN ADD THIS CODE
		
		if(i != -1){			
			// ADD THE -1 TO FIX SPACING			
			for(int l = 0; l < (5*(i - j)-1); l++)System.out.print(" ");			
			System.out.print(i);			
		}		
		System.out.println();
		
	}
    
}
