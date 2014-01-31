package com.dima.algorithms;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

public class StackTest {
	
	@Rule
	public ExpectedException exception = ExpectedException.none();
	
		
	@Test
	public void stackInitTest(){
		int size = 10;
		Stack<String> stringStack = new Stack<String>(size);
		assertTrue(stringStack.stackSize == size);
		assertTrue(stringStack.topOfStack == -1);		
	}
	
	@Test()
	public void emptyStackPeekTest() {
		int size = 10;
		Stack<String> stringStack = new Stack<String>(size);
		assertNull(stringStack.peek());
	}
	
	@Test()
	public void notEmptyStackPeekTest() {
		int size = 10;
		Stack<String> stringStack = new Stack<String>(size);
		String one = "one";
		String two = "two";
		stringStack.push(one);
		assertTrue(stringStack.peek().equals(one));
		assertTrue(stringStack.topOfStack == 0);
		
		stringStack.push(two);
		assertTrue(stringStack.peek().equals(two));
		assertTrue(stringStack.peek().equals(two));
		assertTrue(stringStack.topOfStack == 1);
		
		stringStack.pop();
		assertTrue(stringStack.peek().equals(one));
		assertTrue(stringStack.topOfStack == 0);

		stringStack.pop();
		assertNull(stringStack.peek());
		assertTrue(stringStack.topOfStack == -1);		
	}
	
	@Test()
	public void fullStackPushTest() {
		int size = 3;
		Stack<String> stringStack = new Stack<String>(size);
		stringStack.push("1");
		stringStack.push("1");
		stringStack.push("1");
		
		try {
			stringStack.push("1");
			fail("must fail here");
		} catch (RuntimeException e) {
			assertEquals("Stack is full and you can not push any element to it", e.getMessage());
		}
	}
	
	@Test
	public void emptyStackPopTest() {
		int size = 3;
		Stack<String> stringStack = new Stack<String>(size);		
		exception.expect(RuntimeException.class);
		exception.expectMessage("You can not pop element because stack is empty");
		stringStack.pop();		
	}
	
	@Test
	public void emptyStackPopTest1() {
		int size = 3;
		Stack<String> stringStack = new Stack<String>(size);		
		exception.expect(RuntimeException.class);
		exception.expectMessage("You can not pop element because stack is empty");
		stringStack.push("one");				
		assertEquals("one",stringStack.pop());
		stringStack.pop();
	}
	
	
	@Test
	public void stackPopTest() {
		int size = 3;
		Stack<String> stringStack = new Stack<String>(size);		
		stringStack.push("one");				
		stringStack.push("two");
		assertEquals("two",stringStack.pop());
		assertEquals("one",stringStack.pop());
	}


}
