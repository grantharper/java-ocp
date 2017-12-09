package com.concurrency;

import java.util.concurrent.locks.ReentrantLock;

public class LockExample
{
  
  
  
  public static void main(String[] args)
  {
    ReentrantLock rlock = new ReentrantLock();
    
    rlock.lock();
    boolean b1 = rlock.tryLock();
    System.out.println("tryLock=" + b1);
    
    new Thread(() -> System.out.println("other thread tries to get lock=" + rlock.tryLock())).start();
  }
}
