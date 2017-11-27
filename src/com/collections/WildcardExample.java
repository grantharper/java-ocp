package com.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WildcardExample
{

  public static void main(String[] args)
  {
    String[] a = {"1", "2", "3"};
    List<?> list = new ArrayList<>(Arrays.asList(a));
    //list.add("2"); won't compile because anything could be in here
    list.add(null); //allowed
    String s = (String) list.get(0); //must cast because it only knows that it is an object
    Object o = list.get(0);
    list.forEach(i -> {System.out.print("entry" + i);});
  }
  
  
}
