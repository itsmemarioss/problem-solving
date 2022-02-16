package br.com.itsmemario.hackerrank.interviewpreparation.sorting;

public class MergeSort {
	
	private static int[] tmp;

	public static void main(String[] args) {
		int array[] = {3,2,1,4,0, 100, 43 ,5, 56};
		tmp = new int[array.length];
		mergeSort(array,0, array.length-1);
		for (int i = 0; i < array.length; i++) {
			System.out.printf("%d ",array[i]);
		}
	}

	private static void mergeSort(int[] array, int start, int end) {
		if(start>=end)return;
		
		int middle = start+( (end-start)/2 );
		mergeSort(array, start, middle);
		mergeSort(array, middle+1, end);
		mergeHalves(array, start, middle, end);
		
	}

	private static void mergeHalves(int[] array, int start, int middle, int end) {
		
		int count = 0;
		int j = middle+1;
		int k = start;
		
		for (int i = start; i <= end; i++) {
			if( j>end || (array[k]<array[j] && k <= middle)) {
				tmp[i]=array[k];
				k++;
			}else if ( k > middle || (array[k]>array[j] && j <= end)) {
				tmp[i]=array[j];
				j++;
			}
			count++;
		}
		
		System.arraycopy(tmp, start, array, start, count);
		
	}
}
