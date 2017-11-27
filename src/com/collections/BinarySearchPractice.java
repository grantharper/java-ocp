package com.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BinarySearchPractice
{

  
  public static void main(String[] args)
  {
    List<Integer> integerList = Arrays.asList(5, 4, 7, 1);
    
    Collections.sort(integerList);
    System.out.println(integerList);
    
    Integer result = Collections.binarySearch(integerList, 1);
    System.out.println(result);
    
    //in reverse order using a comparator
    
    Collections.sort(integerList, (a, b) -> b - a);
    System.out.println(integerList);
    
    result = Collections.binarySearch(integerList, 1);
    System.out.println(result);
    
    
    Collections.sort(integerList);
    //if not found, returns (-(insertionPoint) -1) where insertion point is where the key would be inserted (index of first element greater than the key or length of array if it would be the greatest element)
    result = Collections.binarySearch(integerList, 3); //belongs at index 1 so will yield -2
    System.out.println("3 belongs at index 1 so will yield: " + result);
    
    result = Collections.binarySearch(integerList, 9); //belongs at index 3, so will yield -5
    System.out.println("9 belongs at index 4 (size of array), so will yield: "+ result);
  
  } 
}
