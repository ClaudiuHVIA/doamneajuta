package Exercises.WatchProgram;

import java.util.Scanner;

public class Scan implements Runnable
{
  private Clock clock;

  public Scan(Clock clock)
  {
    this.clock = clock;
  }

  @Override public void run()
  {
    Scanner keyboard = new Scanner(System.in);
    int seconds;
    while(true)
    {
      if(keyboard.hasNext())
      {
        seconds = keyboard.nextInt();
        clock.setSeconds(seconds);
      }
    }
    }

}
