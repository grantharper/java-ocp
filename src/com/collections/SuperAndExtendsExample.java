package com.collections;

import java.io.FileNotFoundException;

public class SuperAndExtendsExample
{
  public static <T extends Exception> void getException(T t){
    System.out.println(t.getMessage());
  }

  public static void main(String[] args)
  {
    SuperAndExtendsExample.getException(new NullPointerException("A"));
    //weird syntax here, but it's legal
    SuperAndExtendsExample.<FileNotFoundException>getException(new FileNotFoundException("B"));
    getException(new Exception("C"));
    //<Exception>getException(new Exception("D")); DOES NOT COMPILE
  }
  
  
}
