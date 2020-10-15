/*
 * 04.09.2019 Original version
 */


package FirstMonitor;


import java.util.ArrayList;


public class ColorMonitor
{
	// list contains the colors, that are in pool at the moment
	
	private ArrayList<String> list = new ArrayList<String>();
	
	
	public ColorMonitor()
	{
		// add the colors
		
		list.add( "Red" );
		list.add( "Green" );
		list.add( "Blue" );
	}
	
	
	public synchronized String getColor() // never returns null
	{
		// wait if no colors are available
		while( list.size() == 0 )
			try {
				wait();
			} catch( InterruptedException ex ) {
			}
		
		// here it is guaranteed, that list.size() > 0
		
		return list.remove(0);
	}
	
	
	public synchronized void returnColor( String c )
	{
		list.add( c ); // put a color back in the pool
		
		notify(); // if any threads are waiting in wait() calls on this object,
		          // one of them is made runnable
	}
}
