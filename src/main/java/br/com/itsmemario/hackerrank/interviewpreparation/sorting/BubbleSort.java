package br.com.itsmemario.hackerrank.interviewpreparation.sorting;

import java.util.stream.IntStream;

public class BubbleSort {

	public static void main(String[] args) {
		int[] array = {2,5,1,67,23,60,9,10};
		
		sort(array);
		
		IntStream.of(array).forEach(i -> System.out.println(i));

	}

	private static int[] sort(int[] array) {
		boolean isSorted = false;
		
		while(!isSorted) {	
			isSorted = true;
			for (int i = 0; i < array.length -1; i++) {
				if(array[i]>array[i+1]) {
					swap(array,i,i+1);
					isSorted = false;
				}
			}
			
		}
		return array;
	}

	private static void swap(int[] array, int i, int j) {
		int aux = array[j];
		array[j]=array[i];
		array[i]=aux;
	}

}
