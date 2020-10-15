/*
 * 11.09.2009 Original version
 */
 
package vatprimereverse2;


import java.net.*;

import static vatprimereverse2.Config.*;

import java.io.*;
import javax.swing.*;


public class VPRClient
{
	public static void main( String[] args )
	{
		new VPRClient().run();
	}
	
	
	private String vatIp;
	private String primeReverseIp;
	
	
	public void run()
	{
		vatIp = JOptionPane.showInputDialog( null, "VAT IP" );
		if( vatIp == null || vatIp.length() == 0 )
			return;
			
		primeReverseIp = JOptionPane.showInputDialog( null, "Prime/Reverse IP" );
		if( primeReverseIp == null || primeReverseIp.length() == 0 )
			return;
			
		System.out.println( "VAT of 100: " + vat( 100 ) );
		System.out.println( "VAT of 250: " + vat( 250 ) );
	
		for( long n = 40; n < 50; ++n )
			if( isPrime( n ) )
				System.out.println( "Prime: " + n );
		System.out.println();
		
		System.out.println( "Reverse ABCDEFGH: " + reverse( "ABCDEFGH" ) );
		System.out.println( "Reverse Jan Munch Pedersen: " + reverse( "Jan Munch Pedersen" ) );
	}
	
	
	public double vat( double amount )
	{
		try {
			Socket socket = new Socket( vatIp, VATPORT );
			ObjectOutputStream out = new ObjectOutputStream( socket.getOutputStream() );

			RequestMessage request = new RequestMessage( Action.VAT_REQUEST );
			request.setAmount( amount );
			out.writeObject( request );

			ObjectInputStream in = new ObjectInputStream( socket.getInputStream() ) ;
			
			ResponseMessage response = (ResponseMessage) in.readObject();
			socket.close();
			
			return response.getVat();
		} catch( Exception ex ) {
			ex.printStackTrace();
			
			return 0;
		}
	}
		
	
	public boolean isPrime( long n )
	{
		try {
			Socket socket = new Socket( primeReverseIp, PRPORT );
			ObjectOutputStream out = new ObjectOutputStream( socket.getOutputStream() );

			RequestMessage request = new RequestMessage( Action.PRIME_REQUEST );
			request.setN( n );
			out.writeObject( request );

			ObjectInputStream in = new ObjectInputStream( socket.getInputStream() ) ;
			
			ResponseMessage response = (ResponseMessage) in.readObject();
			socket.close();
			
			return response.getPrime();
		} catch( Exception ex ) {
			ex.printStackTrace();
			
			return false;
		}
	}
		
	
	public String reverse( String s )
	{
		try {
			Socket socket = new Socket( primeReverseIp, PRPORT );
			ObjectOutputStream out = new ObjectOutputStream( socket.getOutputStream() );

			RequestMessage request = new RequestMessage( Action.REVERSE_REQUEST );
			request.setText( s );
			out.writeObject( request );

			ObjectInputStream in = new ObjectInputStream( socket.getInputStream() ) ;
			
			ResponseMessage response = (ResponseMessage) in.readObject();
			socket.close();
			
			return response.getTxet();
		} catch( Exception ex ) {
			ex.printStackTrace();
			
			return "";
		}
	}
}