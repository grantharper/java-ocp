package com.concurrency;

public class InterruptingCow
{

  public static void main(String[] args)
  {
    final Thread mainThread = Thread.currentThread();
    
    Thread interruptingCow = new Thread(() -> {
      try
      {
        Thread.sleep(1600);
        mainThread.interrupt();
      } catch (InterruptedException e)
      {
        System.out.println("Interrupting cow got interrupted");
        e.printStackTrace();
      }
      
    });
    interruptingCow.start();
    
    
    try
    {
      System.out.println("Knock knock");
      Thread.sleep(500);
      System.out.println("Who's there?");
      Thread.sleep(500);
      System.out.println("Interrupting cow");
      Thread.sleep(500);
      System.out.println("Interrupting cow who?");
      Thread.sleep(3000);
    } catch (InterruptedException e)
    {
      System.out.println("Moooooooo!");
      e.printStackTrace();
    }
    
  }
  
}
