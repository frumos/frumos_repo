package com.dima.algorithms;

/**
 * algorithm was taken frome here:
 * https://www.youtube.com/watch?v=9CBRBSWTl-E
 * 
 * @author kovtdm
 *
 */
public class QuickSort {
	
	static int counter = 0;
	
	public int[] makeArray(int size) {
		int[] array = new int[size];		
		for (int i = 0; i < size; i++) {
			array[i] = (int)Math.round(Math.random()*100);
		}
		return array;
	}
	
	
	public void printArray(int[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + ", ");
		}
	}
	
	public int[] quickSort(String msg, int[]array, int start, int end){	
		if(start >= end) return array;
		
		int leftPointer = start;
		int rightPointer = end;
		int pivot = (leftPointer + rightPointer)/2;
		
		System.out.println("------------------");
		printArray(array);
		System.out.println("");
		System.out.println(msg + " Iteratsiya: " + counter++ + " \n left = " + leftPointer + " right = " + rightPointer + " pivot = " + pivot + "\n" );
		System.out.println("------------------");
		
		while(leftPointer < rightPointer) {
			// go from left to pivot
			while((leftPointer < pivot) && (array[leftPointer] <= array[pivot])) leftPointer++;			
			// go from right to pivot			
			while((rightPointer > pivot) && (array[rightPointer] >= array[pivot])) rightPointer--;
			
			// they don't point to the pivot
			if (leftPointer < rightPointer) {
				int tmp = array[leftPointer];
				array[leftPointer] = array[rightPointer];
				array[rightPointer] = tmp;
				
//				if(leftPointer == pivot){
//					System.out.println("HIT LEFT PIVOT EQUAL! for iteration " + counter );
//					pivot = rightPointer;
//				} else if(rightPointer == pivot){
//					System.out.println("HIT RIGHT PIVOT EQUAL! for iteration " + counter);
//					pivot = leftPointer;
//				}
				
			}
		}
		
		quickSort("From left partition", array, start, pivot);
		quickSort("From right partition", array, pivot + 1, end);
		return array;
	}
	

	public static void main(String[] args) {
		int size = 25;
		QuickSort qs = new QuickSort();
		int[] ar = qs.makeArray(size);
		
		qs.quickSort("From main", ar, 0, size-1);	
		
	}

}
