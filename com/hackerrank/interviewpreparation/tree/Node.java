package com.hackerrank.interviewpreparation.tree;

public class Node {
	
	private Node left;
	private Node right;
	private int value;
	
	public Node(int value) {
		this.value = value;
	}
	
	public void insert(int newValue) {
		if(newValue<value) {
			if(left != null) {
				left.insert(newValue);
			}else {
				left = new Node(newValue);
			}
		}else if(newValue > value) {
			if(right!=null) {
				right.insert(newValue);
			}else {
				right = new Node(newValue);
			}
		}
	}
	
	public boolean contains(int value) {
		boolean result = false;
		
		if(this.value == value) {
			result = true;
		}else {
			if(value > this.value && right != null) {
				result = right.contains(value);
			}else if(value < this.value && left != null) {
				result = left.contains(value);
			}
		}
		
		return result;
	}
	
	public void printInOrder() {
		
		if(left!=null) {
			left.printInOrder();
		}
		
		System.out.printf("%d,",value);
		
		if(right!=null) {
			right.printInOrder();
		}
	}
	
	public static void main(String[] args) {
		Node tree = new Node(10);
		tree.printInOrder();
		System.out.println();
		
		tree.insert(15);
		tree.printInOrder();
		System.out.println();
		
		tree.insert(5);
		tree.printInOrder();
		System.out.println();
		
		tree.insert(8);
		tree.printInOrder();
		System.out.println();
		
		
	}

}
