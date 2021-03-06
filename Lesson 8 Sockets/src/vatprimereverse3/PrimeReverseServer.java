///*
// * 20.09.2020 Original version
// */
//
//package vatprimereverse3;
//
//
//import static dk.via.jpe.vatprimereverse3.Config.PRPORT;
//
//import java.net.ServerSocket;
//import java.net.Socket;
//import java.net.InetAddress;
//import java.io.ObjectInputStream;
//import java.io.ObjectOutputStream;
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
//		ObjectInputStream in = new ObjectInputStream( clientSocket.getInputStream() );
//		ObjectOutputStream out = new ObjectOutputStream( clientSocket.getOutputStream() );
//
//		AbstractRequest request = (AbstractRequest) in.readObject();
//
//		if( request instanceof PrimeRequest )
//			out.writeObject( new PrimeResponse( isPrime( ((PrimeRequest) request).getN() ) ) );
//		else if( request instanceof ReverseRequest )
//			out.writeObject( new ReverseResponse( reverse( ((ReverseRequest) request).getText() ) ) );
//		else
//			System.out.println( "Unexpected request" );
//
//		clientSocket.close();
//
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