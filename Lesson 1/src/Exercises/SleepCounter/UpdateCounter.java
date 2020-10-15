package Exercises.SleepCounter;

public class UpdateCounter implements Runnable
{
  private int x;

  public UpdateCounter(int x)
  {
    this.x=x;
  }

  @Override public void run()
  {
    for(int i=0;i<=x;i++)
    {
      System.out.println(i);
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
