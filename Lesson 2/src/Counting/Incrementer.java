package Counting;

public class Incrementer implements Runnable
{
  private static final int COUNT = 50000000;

  private SynchronizedCounter counter;


  public Incrementer( SynchronizedCounter counter )
  {
    this.counter = counter;
  }


  @Override
  public void run()
  {
    for( int i = 0; i < COUNT; ++i )
      counter.increment();
  }
}

