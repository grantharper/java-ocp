package com.classtypes;

public class InstanceOfPractice
{

  public static void main(String[] args)
  {
    Object o = null;
    if(o instanceof Object){
      System.out.println("Object");
    }else{
      System.out.println("null");
    }
  }
  
}
