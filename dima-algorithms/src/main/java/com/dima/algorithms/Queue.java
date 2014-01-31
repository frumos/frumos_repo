package com.dima.algorithms;

public class Queue<T> {
	
	private T[] queue;
	
	private int queueSize;
	
	private int front;
	
	private int rear;
	
	private int numberOfItems;
	
	
	@SuppressWarnings("unchecked")
	public Queue(int size) {
		queue = (T[])new Object[size];
		queueSize = size;
	}
	
	
	public void insert(T item) {
		if(numberOfItems + 1 > queueSize) {
			throw new RuntimeException("queue is full");
		} else {
			System.out.println("Inserting elemnt " + item.toString() + " at rear: " + rear);
			queue[rear++] = item;
			numberOfItems++;
		}
	}
	
	public void remove() {
		if(numberOfItems == 0) {
			throw new RuntimeException("no elemnts in queue");
		} else {
			System.out.println("Removing elemnt " + queue[front].toString() + " at front: " + front);
			numberOfItems--;
			queue[front] = null;
			front++;
		}
	}
	
	public void peek() {
		System.out.println("First elemnt of the queue is: " + queue[front].toString());
	}
	

	public static void main(String[] args) {
		Queue<String> q = new Queue<String>(10);
		
		q.insert("dima");
		q.peek();
		q.insert("alina");
		q.peek();		
		q.insert("sasha");
		q.peek();
		q.insert("olya");
		q.peek();
		
		q.remove();
		q.peek();

		q.remove();
		q.peek();
		
		q.remove();
		q.peek();
		
		q.insert("pricol");
		q.peek();
		q.insert("morda");
		q.peek();
		
		q.remove();
		q.peek();
		
		q.remove();
		q.peek();
		
		
		q.remove();
		
		
		q.insert("pricol");
		q.insert("pricol");
		q.insert("pricol");
		q.insert("pricol");
		q.insert("pricol");
		
		
		
		
		
		
		
		
		
		
		
		
		

	}

}
