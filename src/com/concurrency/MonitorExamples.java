package com.concurrency;

public class MonitorExamples
{

  public static void main(String[] args)
  {
    Object obj = new Object();
    
    try
    {
      obj.wait(1000);
    } catch (InterruptedException | IllegalMonitorStateException e)
    {
      System.out.println("wait was called outside a synchronized block");
      e.printStackTrace();
    }
    System.out.println("After first exception");
    new Thread(() -> waiting(obj, 1)).start();
    new Thread(() -> waiting(obj, 2)).start();
    
    System.out.println("after synchronized block");
  }

  private static void waiting(Object obj, int id)
  {
    synchronized (obj)
    {
      try
      {
        obj.wait(1000);
        System.out.println(id + " executing in a synchronized block");
      } catch (InterruptedException e)
      {
        e.printStackTrace();
      }
    }
  }
  
}
