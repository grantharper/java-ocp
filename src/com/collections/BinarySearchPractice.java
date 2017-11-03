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
  }
  
}
