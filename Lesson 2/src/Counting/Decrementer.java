package Counting;

public class Decrementer implements Runnable
{
  private static final int COUNT = 50000000;

  private SynchronizedCounter counter;


  public Decrementer( SynchronizedCounter counter )
  {
    this.counter = counter;
  }


  @Override
  public void run()
  {
    for( int i = 0; i < COUNT; ++i )
      counter.decrement();
  }
}
