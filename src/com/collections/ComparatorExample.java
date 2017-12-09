package com.collections;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class ComparatorExample
{

  
  public static void main(String[] args)
  {
    List<String> comparingStrings = Arrays.asList("a", "aa", "aaa", "b", "bb", "bbb", "100");
    System.out.println("before sort=" + comparingStrings);
    comparingStrings.sort(Comparator.naturalOrder());
    System.out.println("natural order=" + comparingStrings);
    Comparator<String> customCompare = Comparator.comparing(String::length).thenComparing(Comparator.naturalOrder()).reversed();
    comparingStrings.sort(customCompare);
    
    System.out.println("after sort=" + comparingStrings);
  }
}
