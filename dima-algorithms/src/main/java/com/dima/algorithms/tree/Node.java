package com.dima.algorithms.tree;

public class Node {
	
	String value;
	
	int key;
	
	Node leftChild = null;
	
	Node rightChild = null;
	
	public Node(int key, String value) {
		this.key = key;
		this.value = value;
	}
	
	public String toString() {
		return "Node: " + key;
	}

}
