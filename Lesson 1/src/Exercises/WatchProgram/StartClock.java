package Exercises.WatchProgram;

public class StartClock
{
  public static void main(String[] args)
  {
    Clock clock = new Clock(0,0,0);
    Thread t1 = new Thread(new Count(clock));
    Thread t2 = new Thread(new Scan(clock));
    t1.start();
    t2.start();

  }
}
