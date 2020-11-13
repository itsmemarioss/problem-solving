/**
* Given an array, return an array where each index stores the product of all numbers except the number on the index itself. 
*/
class ProductArray  {  

  //Maybe I could use a map to store the partial values and avoid recalculating everything again.
  public static int[] findProduct(int arr[]) {    

    int [] result = new int[arr.length];

    for(int i=0; i< arr.length; i++) {
      int mult = 1;

      for(int j=i+1; j < arr.length; j++) {
        mult *= arr[j];
      }

      for(int j=0; j < i; j++) {
        mult *= arr[j];
      }

      result[i]=mult;
    }

    return result; 
   } 
} 
