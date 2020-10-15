/*
 * 01.09.2019 Original version
 */


// A small utility class used for counting

package Counting;


public class SynchronizedCounter
{
	private long value;

	public SynchronizedCounter(long value)
	{
		this.value = value;
	}


	public synchronized void increment()
	{
		++value;
	}

	public synchronized void decrement()
	{
		--value;
	}

	public synchronized long getCount()
	{
		return value;
	}
}
