///*
// * 10.09.2019 package name changed
// * 06.10.2014 Edited
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
//import javax.swing.*;
//
//
//public class VPRClient
//{
//	public static void main( String[] args )
//	{
//		new VPRClient().run();
//	}
//
//
//	private String vatIp;
//	private String primeReverseIp;
//
//
//	public void run()
//	{
//		vatIp = JOptionPane.showInputDialog( null, "VAT IP" );
//		if( vatIp == null || vatIp.length() == 0 )
//			return;
//
//		primeReverseIp = JOptionPane.showInputDialog( null, "Prime/Reverse IP" );
//		if( primeReverseIp == null || primeReverseIp.length() == 0 )
//			return;
//
//		System.out.println( "VAT of 100: " + vat( 100 ) );
//		System.out.println( "VAT of 250: " + vat( 250 ) );
//
//		for( long n = 40; n < 50; ++n )
//			if( isPrime( n ) )
//				System.out.println( "Prime: " + n );
//		System.out.println();
//
//		System.out.println( "Reverse ABCDEFGH: " + reverse( "ABCDEFGH" ) );
//		System.out.println( "Reverse Jan Munch Pedersen: " + reverse( "Jan Munch Pedersen" ) );
//	}
//
//
//	public double vat( double amount )
//	{
//		try {
//			Socket socket = new Socket( vatIp, VATPORT );
//
//			BufferedReader in = new BufferedReader(
//				new InputStreamReader( socket.getInputStream() ) );
//
//			OutputStreamWriter out =
//				new OutputStreamWriter( socket.getOutputStream() );
//
//			String output = "" + amount + "\n";
//			System.out.println( "SENDING: " + output );
//			out.write( output );
//			out.flush();
//
//			String input = in.readLine();
//			System.out.println( "RECEIVED: " + input );
//			double vat = Double.parseDouble( input );
//
//			socket.close();
//
//			return vat;
//		} catch( Exception ex ) {
//			ex.printStackTrace();
//
//			return 0;
//		}
//	}
//
//
//	public boolean isPrime( long n )
//	{
//		try {
//			Socket socket = new Socket( primeReverseIp, PRPORT );
//
//			BufferedReader in = new BufferedReader(
//				new InputStreamReader( socket.getInputStream() ) );
//
//			OutputStreamWriter out =
//				new OutputStreamWriter( socket.getOutputStream() );
//
//			String output = "P" + n + "\n";
//			System.out.println( "SENDING: " + output );
//			out.write( output );
//			out.flush();
//
//			String input = in.readLine();
//			System.out.println( "RECEIVED: " + input );
//			boolean res = Boolean.parseBoolean( input );
//
//			socket.close();
//
//			return res;
//		} catch( Exception ex ) {
//			ex.printStackTrace();
//
//			return false;
//		}
//	}
//
//
//	public String reverse( String s )
//	{
//		try {
//			Socket socket = new Socket( primeReverseIp, PRPORT );
//
//			BufferedReader in = new BufferedReader(
//				new InputStreamReader( socket.getInputStream() ) );
//
//			OutputStreamWriter out =
//				new OutputStreamWriter( socket.getOutputStream() );
//
//			String output = "R" + s + "\n";
//			System.out.println( "SENDING: " + output );
//			out.write( output );
//			out.flush();
//
//			String input = in.readLine();
//			System.out.println( "RECEIVED: " + input );
//
//			socket.close();
//
//			return input;
//		} catch( Exception ex ) {
//			ex.printStackTrace();
//
//			return "";
//		}
//	}
//}