///*
// * 20.09.2020 Switched to Runnable
// * 10.09.2019 package name changed
// * 13.03.2011 Edited
// * 15.03.2009 Original version
// */
//
//package dk.via.jpe.vatprimereverse;
//
//
//import java.net.*;
//
//import static dk.via.jpe.vatprimereverse.Config.*;
//
//import java.io.*;
//
//
//public class VATServer
//{
//	private static final double VATRATE = 0.25;
//
//
//	public static void main( String[] args )
//	{
//		new VATServer().run();
//	}
//
//
//	private void run()
//	{
//		try {
//			ServerSocket welcomeSocket = new ServerSocket( VATPORT );
//
//			System.out.println( "VAT Server listening on " + InetAddress.getLocalHost().getHostAddress() );
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
//		double amount = Double.parseDouble( input );
//
//		double vat = VATRATE * amount;
//
//		String output = "" + vat + "\n";
//		System.out.println( "SENDING: " + output );
//		out.write( output );
//		out.flush();
//
//		clientSocket.close();
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