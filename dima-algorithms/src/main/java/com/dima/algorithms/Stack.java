
package com.dima.algorithms;

/**
 * 
 * @author kovtdm
 *
 */
public class Stack<T> {
	
	private T[] stack;
	
	int stackSize;
	
	int topOfStack = -1;
	
	@SuppressWarnings("unchecked")
	public Stack(int size) {
		stack = (T[])new Object[size];
		stackSize = size;
	}
	
	public T peek(){
		if (topOfStack != -1) {
			return stack[topOfStack];
		} else {
			return null;
		}
	}
	
	public void push(T element){
		if(topOfStack + 1 < stackSize) {
			stack[++topOfStack] = element;
		} else {
			throw new RuntimeException("Stack is full and you can not push any element to it");
		}		
	}
	
	public T pop() {
		if(topOfStack < 0) {
			throw new RuntimeException("You can not pop element because stack is empty");
		} else {
			return stack[topOfStack--];
		}
	}

}
