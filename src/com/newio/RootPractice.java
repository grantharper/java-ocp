package com.newio;

import java.nio.file.Path;
import java.nio.file.Paths;

public class RootPractice
{

  public static void main(String[] args)
  {
    Path p1 = Paths.get("c:\\a\\b\\c");
    
    System.out.println("root:" + p1.getRoot());
  }
  
}
