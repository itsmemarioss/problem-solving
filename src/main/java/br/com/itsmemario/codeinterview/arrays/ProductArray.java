package br.com.itsmemario.codeinterview.arrays;

/**
* Given an array, return an array where each index stores the product of all numbers except the number on the index itself. 
*/
class ProductArray {
 
  public static int[] findProduct(int arr[]) {    

    int [] result = new int[arr.length];
    int previous = 1;

    for(int i=0; i< arr.length; i++) {
      int mult = 1;

      for(int j=i+1; j < arr.length; j++) {
        mult *= arr[j];
      }

      result[i]=previous * mult;

      previous *= arr[i];
    }

    return result;
  } 
} 
