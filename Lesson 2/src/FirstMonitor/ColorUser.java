/*
 * 29.08.2020 Switched to Runnable
 * 04.09.2019 Original version
 */


package FirstMonitor;


import java.util.Random;


public class ColorUser
	implements Runnable
{
	private static final Random random = new Random();
	
	
	private ColorMonitor colors;
	private int no;
	
	
	public ColorUser( ColorMonitor colors, int no )
	{
		this.colors = colors;
		this.no = no;
	}
	
	
	@Override
	public void run()
	{
		while( true ) {
			try {
				Thread.sleep( random.nextInt( 5000 ) );
			} catch( InterruptedException ex ) {
			}
			
			System.out.println( "Thread #" + no + " wants a color" );
			
			String c = colors.getColor();
			
			System.out.println( "Thread #" + no + " got the color " + c );
			
			try {
				Thread.sleep( random.nextInt( 10000 ) );
			} catch( InterruptedException ex ) {
			}
			
			System.out.println( "Thread #" + no + " returns the color " + c );
			
			colors.returnColor( c );
		}
	}
}
