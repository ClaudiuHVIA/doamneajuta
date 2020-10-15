package Exercises.WatchProgram;

import java.util.Scanner;

public class Count implements Runnable
{
  private Clock clock;

  public Count(Clock clock)
  {
    this.clock = clock;
  }

  @Override public void run()
  {
    while(true)
    {
      clock.tic();
      System.out.println(clock);
      try
      {
        Thread.sleep(10000);
      }
      catch (InterruptedException e)
      {
        e.printStackTrace();
      }
    }
  }
}
