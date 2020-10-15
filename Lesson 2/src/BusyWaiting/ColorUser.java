/*
 * 29.08.2020 implements Runnable
 * 04.09.2019 Original version
 */


package BusyWaiting;


import java.util.Random;


public class ColorUser
	implements Runnable
{
	private static final Random random = new Random();
	
	
	private ColorPool colors;
	private int no;
	
	
	public ColorUser( ColorPool colors, int no )
	{
		this.colors = colors;
		this.no = no;
	}
	
	
	@Override
	public void run()
	{
		while( true ) {
			try {
				Thread.sleep( random.nextInt( 5000 ) ); // wait a random period of time
			} catch( InterruptedException ex ) {
			}
			
			System.out.println( "Thread #" + no + " wants a color" );
			
			// try to get a color -- loop until it one is received
			
			String c = colors.getColor();
			while( c == null )
				c = colors.getColor();
			
			System.out.println( "Thread #" + no + " got the color " + c );
			
			try {
				Thread.sleep( random.nextInt( 10000 ) );
			} catch( InterruptedException ex ) {
			}
			
			System.out.println( "Thread #" + no + " returns the color " + c );
			
			// return the color 
			colors.returnColor( c );
		}
	}
}
