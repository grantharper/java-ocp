package com.streams;

import java.util.Arrays;
import java.util.List;

public class MatchingPractice
{

  public static void main(String[] args)
  {
    List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6);
    
    boolean anyMatch = list.stream().anyMatch(i -> i == 5);
    
    System.out.println("Any match 5: " + anyMatch);
    
    boolean allMatch = list.stream().allMatch(i -> i instanceof Integer);
    
    System.out.println("All match instanceof Integer: " + allMatch);
    
    boolean noneMatch = list.stream().noneMatch(i -> i == new Integer(3));
    
    System.out.println("None match new Integer(3): " + noneMatch);
    
  }
  
  
}
