package com.collections;

import java.util.ArrayList;
import java.util.List;

public class NoGenericExample
{

  public static void main(String[] args)
  {
    List<Object> list = new ArrayList<>(); //list of objects
    
    list.add("String");
    list.add(12);
    list.add(23L);
    list.add(30.0);
    
    for(Object item : list){
      System.out.println(item);
    }
    
    //you can't pretend you know the objects are String. DOES NOT COMPILE
    /*for(String item: list){
      System.out.println(item);
    }*/
  }
  
}
