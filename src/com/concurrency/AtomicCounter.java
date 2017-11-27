package com.concurrency;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicCounter
{

  public static void main(String[] args)
  {
    
    System.out.println("Examples of how to use the atomic integer (initialized at 0)");
    AtomicInteger a = new AtomicInteger(0);
    System.out.println("incrementAndGet=" + a.incrementAndGet());
    System.out.println("getAndIncrement=" + a.getAndIncrement());
    System.out.println("value was updated after getting=" + a.get());
    System.out.println("addAndGet(3)=" + a.addAndGet(3)); //5
    System.out.println("updateAndGet(i -> i * 2) UnaryOperator=" + a.updateAndGet(i-> i * 2));
    System.out.println("accumulateAndGet(2, (x,y)->x+y)=" + a.accumulateAndGet(2, (x /*value of a*/, y /*passed in value (2)*/) -> x * y)); //20
    System.out.println("getAndSet(1)=" + a.getAndSet(1));
    System.out.println("now that it is updated=" + a.get());
    a.set(2);
    System.out.println("after set(2)=" + a.get());
    
  }
  
}
