/*
 * 20.09.2020 Switched to Runnable
 * 11.09.2019 Original version
 */
 
package vatprimereverse2;


import java.net.*;

import static vatprimereverse2.Config.*;

import java.io.*;


public class VATServer
{
	private static final double VATRATE = 0.25;
	
	
	public static void main( String[] args )
	{
		new VATServer().run();
	}
	
	
	private void run()
	{
		try {
			ServerSocket welcomeSocket = new ServerSocket( VATPORT );
			
			System.out.println( "VAT Server listening on " + InetAddress.getLocalHost().getHostAddress() );
		
			while( true ) {
				Socket clientSocket = welcomeSocket.accept();
				
				new Thread( new ServerThread( clientSocket ) ).start();
			}
		} catch( Exception ex ) {
			ex.printStackTrace();
		}
	}
	
	
	private void doWork( Socket clientSocket )
		throws Exception
	{
		ObjectInputStream in = new ObjectInputStream( clientSocket.getInputStream() );
		ObjectOutputStream out = new ObjectOutputStream( clientSocket.getOutputStream() );

		RequestMessage request = (RequestMessage) in.readObject();
		
		if( request.getAction() != Action.VAT_REQUEST ) {
			System.out.println( "Unexpected action " + request.getAction() );
		} else {
			ResponseMessage response = new ResponseMessage( Action.VAT_RESPONSE );
			response.setVat( VATRATE * request.getAmount() );
			out.writeObject( response );
		}
			
		clientSocket.close();
	}
	
	
	private class ServerThread
		implements Runnable
	{
		private Socket clientSocket;
		
		
		public ServerThread( Socket clientSocket )
		{
			this.clientSocket = clientSocket;
		}
		
		
		public void run()
		{
			try {
				doWork( clientSocket );
			} catch( Exception ex ) {
				ex.printStackTrace();
			}
		}
	}
}