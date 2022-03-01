package br.com.itsmemario.codeinterview.arrays;

class CheckMergeArray {
    // merge arr1 and arr2 into a new result array 
    public static int[] mergeArrays(int[] arr1, int[] arr2){  
      
      int size = arr1.length + arr2.length;

      int[] merged = new int[size];
      
      int j = 0;
      int z = 0;

      for(int i = 0; i < merged.length; i++){
        int a = Integer.MAX_VALUE;
        int b = Integer.MAX_VALUE;

        if( j < arr1.length){
          a = arr1[j];
        }

        if( z < arr2.length){
          b = arr2[z];
        }

        if(a <= b){
          merged[i] = a;
          j++;
        }else{
          merged[i] = b;
          z++;
        }

      }

      return merged;
    } 
}
