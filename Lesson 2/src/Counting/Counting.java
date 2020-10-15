/*
 * 29.08.2020 Switched to Runnable
 * 01.09.2019 Original version
 */


package Counting;


public class Counting
{
	public static void main( String[] args )
	{
		long value =0;
		SynchronizedCounter counter = new SynchronizedCounter(value);
		
		// Creating two Threads, that executes the same code
		
		Thread c1 = new Thread( new Incrementer( counter ) );
		Thread c2 = new Thread( new Decrementer( counter ) );

		c1.start();
		c2.start();
		
		try {
			c1.join(); // waits for the c1 Thread to end
			c2.join();
		} catch( InterruptedException ex ) {
			ex.printStackTrace();
		}
		
		System.out.println( counter.getCount() );
	}
}
