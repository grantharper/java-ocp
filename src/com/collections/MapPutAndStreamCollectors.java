package com.collections;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MapPutAndStreamCollectors
{

  public static void main(String[] args)
  {
    Map<String,String> map = new HashMap<>();
    
    map.put("a", "b");
    String former = map.put("a", "c");//no issue, replaces key
    System.out.println("formerly was=" + former);
    System.out.println(map.get("a"));
    
    List<String> info = Arrays.asList("a", "bb", "cc");
    
    //IllegalStateException because of duplicate key
    Map<Integer, String> map2 = info.stream().collect(Collectors.toMap(String::length, i -> i)); //will throw exception for duplicate key
  }
  
}
