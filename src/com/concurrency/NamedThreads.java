package com.concurrency;

public class NamedThreads
{

  public static void main(String[] args)
  {
    new Thread(() -> System.out.println(Thread.currentThread().getName()),"cool thread").start();
    System.out.println(Thread.currentThread().getName());
    
    
  }
  
  
}
