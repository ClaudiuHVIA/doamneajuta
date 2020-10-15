package Exercises.Clock;//package Exercises;

public class TimerThread implements Runnable
{
  private Clock clock;

  public TimerThread(Clock clock)
  {
    this.clock = clock;
  }

  @Override public void run()
  {
    while(true)
    {
      clock.increaseSeconds();
      System.out.println((clock.getSeconds() / 60) / 60 + " : " + clock.getSeconds() / 60 + " : " + clock.getSeconds() % 60);
      try
      {
        Thread.sleep(1000);
      }
      catch (InterruptedException e)
      {
        e.printStackTrace();
      }
    }
  }
}
