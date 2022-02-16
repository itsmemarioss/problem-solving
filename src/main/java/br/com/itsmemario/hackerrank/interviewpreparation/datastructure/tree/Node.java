package br.com.itsmemario.hackerrank.interviewpreparation.datastructure.tree;

public class Node {
	
	private Node left;
	private Node right;
	private int data;
	
	public Node(int value) {
		this.data = value;
	}
	
	public void insert(int newValue) {
		if(newValue<data) {
			if(left != null) {
				left.insert(newValue);
			}else {
				left = new Node(newValue);
			}
		}else if(newValue > data) {
			if(right!=null) {
				right.insert(newValue);
			}else {
				right = new Node(newValue);
			}
		}
	}
	
	public boolean contains(int data) {
		boolean result = false;
		
		if(this.data == data) {
			result = true;
		}else {
			if(data > this.data && right != null) {
				result = right.contains(data);
			}else if(data < this.data && left != null) {
				result = left.contains(data);
			}
		}
		
		return result;
	}
	
	public void printInOrder() {
		
		if(left!=null) {
			left.printInOrder();
		}
		
		System.out.printf("%d,",data);
		
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
