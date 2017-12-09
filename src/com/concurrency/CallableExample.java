package com.concurrency;

import java.util.concurrent.Callable;

public class CallableExample
{

  class Phone implements Callable<String>{

    @Override
    public String call() throws Exception
    {
      return "Hello";
    }
    
  }
  
  public static void main(String[] args) throws Exception
  {
    CallableExample ce = new CallableExample();

    Phone p = ce.new Phone();
    String s = p.call(); //single threaded. Need to use an executor service to make multi-threading possible
    
    System.out.println(s);
  }
  
}
