package br.com.itsmemario.hackerrank.interviewpreparation.datastructure;

import java.util.Arrays;

public class Heap {
	
	private int[] items;
	private int size;

	public Heap(int capacity) {
		super();
		this.items = new int[capacity];
		size = 0;
	}
	
	public int getLeftChildIndex(int index) {
		return (index*2)+1;
	}
	
	public int getRightChildIndex(int index) {
		return (index*2)+2;
	}
	
	public int getParentIndex(int index) {
		return (index-1)/2;	
	}
	
	public boolean hasLeftChild(int index) {
		return getLeftChildIndex(index) < size;
	}
	
	public boolean hasRightChild(int index) {
		return getRightChildIndex(index) < size;
	}
	
	public boolean hasParent(int index) {
		return getParentIndex(index) >= 0;
	}
	
	public int leftChild(int index) {
		return items[getLeftChildIndex(index)];
	}
	
	public int rightChild(int index) {
		return items[getRightChildIndex(index)];
	}
	
	public int parent(int index) {
		return items[getParentIndex(index)];
	}
	
	private void swap(int indexOne, int indexTwo) {
		int aux = items[indexOne];
		items[indexOne] = items[indexTwo];
		items[indexTwo] = aux;
	}
	
	private void ensureExtraCapacity() {
		if(size == items.length) {
			items = Arrays.copyOf(items, items.length*2);
		}
	}
	
	public int peek() {
		if(size==0) throw new IllegalStateException("No elements inside!");
		return items[0];
	}
	
	public int poll() {
		if(size==0) throw new IllegalStateException("No elements inside!");
		int result = items[0];
		items[0] = items[size -1];
		size--;
		heapifyDown();
		return result;
	}

	public void add(int i) {
		ensureExtraCapacity();
		items[size] = i;
		size++;
		heapifyUp();
	}
	
	private void heapifyUp() {
		int lastIndex = size-1;
		
		while(hasParent(lastIndex) && parent(lastIndex)>items[lastIndex]) {
			swap(getParentIndex(lastIndex),lastIndex);
			lastIndex = getParentIndex(lastIndex);
		}
		
	}

	private void heapifyDown() {
		int index = 0;
		
		while(hasLeftChild(index)) {
			int smallerChildIndex = getLeftChildIndex(index);
			if(leftChild(index)>rightChild(index))
				smallerChildIndex = getRightChildIndex(index);
			
			if(items[index]<items[smallerChildIndex]) {
				break;
			}else {
				swap(index, smallerChildIndex);
				index = smallerChildIndex;
			}
			
		}	
	}
	
	private void printHeap() {
		System.out.print("[");
		for (int i = 0; i < items.length; i++) {
			System.out.printf("%d,",items[i]);
		}
		System.out.println("]");
	}
	
	
	public static void main(String[] args) {
		Heap heap = new Heap(10);
		
		heap.add(5);
		System.out.println(heap.peek());
		heap.add(10);
		System.out.println(heap.peek());
		heap.add(8);
		System.out.println(heap.peek());
		heap.add(3);
		System.out.println(heap.peek());
		
		System.out.println(heap.poll());
		
		heap.printHeap();
	}


}
