///*
// * 20.09.2020 Original version
// */
//
//package dk.via.jpe.vatprimereverse3;
//
//
//import java.net.ServerSocket;
//import java.net.Socket;
//import java.net.InetAddress;
//
//import static dk.via.jpe.vatprimereverse3.Config.VATPORT;
//
//import java.io.ObjectInputStream;
//import java.io.ObjectOutputStream;
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
//		ObjectInputStream in = new ObjectInputStream( clientSocket.getInputStream() );
//		ObjectOutputStream out = new ObjectOutputStream( clientSocket.getOutputStream() );
//
//		AbstractRequest request = (AbstractRequest) in.readObject();
//
//		if( request instanceof VATRequest )
//			out.writeObject( new VATResponse( VATRATE * ((VATRequest) request).getAmount() ) );
//		else
//			System.out.println( "Unexpected request" );
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