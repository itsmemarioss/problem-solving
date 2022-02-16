package br.com.itsmemario.hackerrank.interviewpreparation.sorting;

public class Quicksort {
	
	public void sort(int[] array) {
		quicksort(array, 0, array.length-1);
	}
	
	public void quicksort(int[] array, int left, int right) {
		if(left >= right) {
			return;
		}
		int pivot = array[(left+right)/2];
		int index = partition(array, left, right, pivot);
		quicksort(array,left, index -1);
		quicksort(array, index, right);
		
	}

	private int partition(int[] array, int left, int right, int pivot) {
		while(left <= right) {
			while(array[left]<pivot) {
				left++;
			}
			
			while(array[right]>pivot) {
				right--;
			}
			
			if(left<= right) {
				swap(array, left, right);
				left++;
				right--;
			}
		}
		return left;
	}

	private void swap(int[] array, int a, int b) {
		int aux = array[a];
		array[a] = array[b];
		array[b] = aux;
	}
	
	public static void main(String[] args) {
		int[] array = new int[]{4,2,3,9,1,7,8,23,11,45,6,13};
		printArray(array);
		new Quicksort().sort(array);
		printArray(array);
	}

	private static void printArray(int[] array) {
		System.out.print("[");
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i]);
			if(i<array.length-1)
				System.out.print(",");
		}
		System.out.println("]");
		
	}

}
