package com.concurrency;

import static java.util.concurrent.TimeUnit.*;
import java.util.concurrent.*;

public class BeeperControl
{
  private final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

  public void beepForAMinute()
  {
    final ScheduledFuture<?> beeperHandle = scheduler.scheduleAtFixedRate(() -> System.out.println("beep"), 1, 1,
        SECONDS);
    scheduler.schedule(() -> beeperHandle.cancel(true), 60, SECONDS);
  }

  public static void main(String args[])
  {
    new BeeperControl().beepForAMinute();
  }
}
