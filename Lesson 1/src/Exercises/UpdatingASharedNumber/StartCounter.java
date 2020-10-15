package Exercises.UpdatingASharedNumber;

import java.util.zip.CheckedOutputStream;

public class StartCounter
{
  public static void main(String[] args)
  {
    Counter counter = new Counter();
    Thread t1 = new Thread(new CountIncrementer(counter));
    Thread t2 = new Thread(new CountIncrementer(counter));
    t1.start();
    try
    {
      t1.join();
    }
    catch (InterruptedException e)
    {
      e.printStackTrace();
    }
    t2.start();
  }
}
