/*
 * 29.08.2020 Threads now Runnable
 * 04.09.2019 Original version
 */


package FirstMonitor;


public class MonitorWaiting
{
	private static int NO_OF_THREADS = 6;
	
	
	public static void main( String[] args )
	{
		ColorMonitor colors = new ColorMonitor();
		
		for( int i = 1; i <= NO_OF_THREADS; ++i ) {
			Thread c = new Thread( new ColorUser( colors, i ) );
			c.start();
		}
	}
}
