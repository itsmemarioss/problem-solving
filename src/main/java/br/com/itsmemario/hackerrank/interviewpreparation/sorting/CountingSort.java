package br.com.itsmemario.hackerrank.interviewpreparation.sorting;

public class CountingSort {
	
	public static void sort(int[] array) {
		int max = findMax(array);
		int[] aux = new int[max+1];
		int[] result = new int[array.length];
		
		count(array, aux);
		
		adjustPosition(aux);
		
		sort(array, aux, result);
		
		print(result);
		
	}

	private static void print(int[] result) {
		for (int i = 0; i < result.length; i++) {
			System.out.print(result[i]+" ");
		}
	}

	private static void sort(int[] array, int[] aux, int[] result) {
		for (int i = 0; i < array.length; i++) {
			int value = array[i];
			int resultPosition = aux[value] - 1;
			aux[value]--;
			result[resultPosition] = value;
		}
	}

	private static void adjustPosition(int[] aux) {
		for (int i = 1; i < aux.length; i++) {
			aux[i] = aux[i-1]+aux[i];
		}
	}

	private static void count(int[] array, int[] aux) {
		for (int i = 0; i < array.length; i++) {
			aux[array[i]]++;
		}
	}

	private static int findMax(int[] array) {
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < array.length; i++) {
			if(array[i] > max) max = array[i];
		}
		return max;
	}
	
	public static void main(String[] args) {
		sort(new int[]{53,2,1,896,0,8});
	}

}
