/*
 * 29.08.2020 Switched to Runnable
 * 01.09.2019 Original version
 */


package Counting;


public class CountingThread
	implements Runnable
{
	private static final int COUNT = 50000000;
	
	private SynchronizedCounter counter;
	
	
	public CountingThread( SynchronizedCounter counter )
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
