package br.com.itsmemario.codeinterview;

import java.util.*;

/**
* Challenge 6: First Non-Repeating Integer in an Array
* Given an array, find the first integer, which is unique in the array. 
* Unique means the number does not repeat and appears only once in the whole array.
*/
class CheckFirstUnique{
  public static int findFirstUnique(int[] arr)  {
 
    int result = -1;
    Map<Integer, Integer> map = new HashMap<>();
    LinkedList<Integer> uniques = new LinkedList<>();
    
    for(int i = 0; i< arr.length;i++){
      map.compute(arr[i], (k,v) ->  v == null?1:v+1);
      if(map.get(arr[i]) == 1){
        uniques.add(arr[i]);
      }else{
        uniques.remove(Integer.valueOf(arr[i]));
      }
    }

    return uniques.isEmpty() ? result: uniques.remove();
  }
}
