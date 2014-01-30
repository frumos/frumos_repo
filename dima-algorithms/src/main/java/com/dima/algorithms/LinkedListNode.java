package com.dima.algorithms;

public class LinkedListNode<T> {
	
	private LinkedListNode<T> next = null;
	
	private T value;
	
	public LinkedListNode(T value) {
		this.value = value;
	}
	
	public void append(T value) {
		LinkedListNode<T> end = new LinkedListNode<T>(value);
		LinkedListNode<T> n = this;
		
		while (n.next != null) {
			n = n.next;
		}		
		n.next = end;
	}	
	
	public void printLinkedList() {
		LinkedListNode<T> node = this;
		while (node.next != null) {
			System.out.println(node.value);
			node = node.next;
		}
		System.out.println(node.value);
	}
	
	
	
	public static void main(String[] args) {
		LinkedListNode<String> ll = new LinkedListNode<String>("dima");
		ll.append("private");
		ll.append("hello");
		
		ll.printLinkedList();
	}

}
