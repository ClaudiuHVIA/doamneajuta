///*
// * 20.09.2020 Switched to Runnable
// * 10.09.2019 package name changed
// * 13.03.2011 Edited
// * 15.03.2009 Original version
// */
//
//package vatprimereverse;
//
//
//import java.net.*;
//
//import vatprimereverse.Config;
//
//import java.io.*;
//
//
//public class PrimeReverseServer
//{
//	public static void main( String[] args )
//	{
//		new PrimeReverseServer().run();
//	}
//
//
//	private void run()
//	{
//		try {
//			ServerSocket welcomeSocket = new ServerSocket( PRPORT );
//
//			System.out.println( "Prime/Reverse Server listening on " + InetAddress.getLocalHost().getHostAddress() );
//
//			while( true ) {
//				Socket clientSocket = welcomeSocket.accept();
//
//				new Thread( new ServerThread( clientSocket ) ).start();
//			}
//		} catch( Exception ex ) {
//			ex.printStackTrace();
//		}
//	}
//
//
//	private void doWork( Socket clientSocket )
//		throws Exception
//	{
//		BufferedReader in = new BufferedReader(
//			new InputStreamReader( clientSocket.getInputStream() ) );
//
//		OutputStreamWriter out =
//			new OutputStreamWriter( clientSocket.getOutputStream() );
//
//		String input = in.readLine();
//		System.out.println( "RECEIVED: " + input );
//
//		String output;
//
//		switch( input.charAt(0) ) {
//			case 'P':
//				long n = Long.parseLong( input.substring( 1 ) );
//				output = "" + isPrime( n );
//				break;
//
//			case 'R':
//				output = reverse( input.substring( 1 ) );
//				break;
//
//			default:
//				output = "";
//				break;
//		}
//
//		System.out.println( "SENDING: " + output );
//		out.write( output );
//		out.flush();
//
//		clientSocket.close();
//	}
//
//
//	private boolean isPrime( long n )
//	{
//		if( n <= 3 )
//			return n == 2 || n == 3;
//		else if( n % 2 == 0 )
//			return false;
//		else {
//			for( long d = 3; d * d <= n; d += 2 )
//				if( n % d == 0 )
//					return false;
//
//			return true;
//		}
//	}
//
//
//	private String reverse( String input )
//	{
//		String output = "";
//
//		while( input.length() > 0 ) {
//			output = input.substring( 0, 1 ) + output;
//			input = input.substring( 1 );
//		}
//
//		return output;
//	}
//
//
//	private class ServerThread
//		implements Runnable
//	{
//		private Socket clientSocket;
//
//
//		public ServerThread( Socket clientSocket )
//		{
//			this.clientSocket = clientSocket;
//		}
//
//
//		public void run()
//		{
//			try {
//				doWork( clientSocket );
//			} catch( Exception ex ) {
//				ex.printStackTrace();
//			}
//		}
//	}
//}