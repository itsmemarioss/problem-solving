package br.com.itsmemario.codeinterview.arrays;

import java.util.Arrays;

/**
* Given an array and a number "n", find two numbers from the array that sums up to "n". Implement your solution in Java and see if your output matches with the correct output.
*/
class CheckSum {   
  public static int[] findSum(int[] arr, int n) {
    int[] result = new int[2];
    Arrays.sort(arr);

    for(int i = 0; i< arr.length; i++){
      int secondValue = n - arr[i];
      int position = Arrays.binarySearch(arr, secondValue);
      if(position >= 0){
        result[0]=arr[i];
        result[1]=secondValue;
        break;
      }      
    }
    // write your code here
    return result;   // return the elements in the array whose sum is equal to the value passed as parameter 
  }
}
