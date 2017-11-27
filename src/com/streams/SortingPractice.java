package com.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Comparator;

public class SortingPractice
{
  
  

  public static void main(String[] args)
  {
    List<String> cakes = Arrays.asList("chocolate", "pumpkin", "funfetti", "apple");
    System.out.println("Sort according to natual order");
    System.out.println(cakes.stream().sorted().collect(Collectors.joining(", ")));
    System.out.println("Sort according to passed in comparator using the Comparable interface on string length");
    System.out.println(cakes.stream().sorted(Comparator.comparing(a -> a.length())).collect(Collectors.joining(", ")));
    System.out.println("Sort according to passed in comparator (in this case reverse natural order)");
    System.out.println(cakes.stream().sorted((a, b)-> b.compareTo(a)).collect(Collectors.joining(", ")));
  }
  
  
}
