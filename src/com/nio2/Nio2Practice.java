package com.nio2;

import java.nio.file.Path;
import java.nio.file.Paths;

public class Nio2Practice
{

  public static void main(String[] args)
  {
    
    Path p = Paths.get("test.txt");
    
    
    System.out.println(p.toAbsolutePath());
    
    
    Path p2 = Paths.get("a", "b", "c", "d");
    System.out.println(p2);
    
    System.out.println("subpath(1,2)=" + p2.subpath(1, 2));
    
    try{
      System.out.println(p2.subpath(0, 5)); //will throw exception because 5-0=5 and there are only 4 path elements
    }catch(IllegalArgumentException e){
      e.printStackTrace();
    }
    
    
  }
  
  
}
