///*
// * 20.09.2020 Original version
// */
//
//package dk.via.jpe.vatprimereverse3;
//
//
//import static dk.via.jpe.vatprimereverse3.Config.VATPORT;
//import static dk.via.jpe.vatprimereverse3.Config.PRPORT;
//
//import java.net.Socket;
//import java.io.ObjectInputStream;
//import java.io.ObjectOutputStream;
//import javax.swing.JOptionPane;
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
//			ObjectOutputStream out = new ObjectOutputStream( socket.getOutputStream() );
//
//			out.writeObject( new VATRequest( amount ) );
//
//			ObjectInputStream in = new ObjectInputStream( socket.getInputStream() ) ;
//
//			AbstractResponse response = (AbstractResponse) in.readObject();
//			socket.close();
//
//			if( response instanceof VATResponse )
//				return ((VATResponse) response).getVat();
//			else {
//				System.out.println( "Unexpected response" );
//
//				return -1.0;
//			}
//		} catch( Exception ex ) {
//			ex.printStackTrace();
//
//			return -1.0;
//		}
//	}
//
//
//	public boolean isPrime( long n )
//	{
//		try {
//			Socket socket = new Socket( primeReverseIp, PRPORT );
//			ObjectOutputStream out = new ObjectOutputStream( socket.getOutputStream() );
//
//			out.writeObject( new PrimeRequest( n ) );
//
//			ObjectInputStream in = new ObjectInputStream( socket.getInputStream() ) ;
//
//			AbstractResponse response = (AbstractResponse) in.readObject();
//			socket.close();
//
//			if( response instanceof PrimeResponse )
//				return ((PrimeResponse) response).getPrime();
//			else {
//				System.out.println( "Unexpected response" );
//
//				return false;
//			}
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
//			ObjectOutputStream out = new ObjectOutputStream( socket.getOutputStream() );
//
//			out.writeObject( new ReverseRequest( s ) );
//
//			ObjectInputStream in = new ObjectInputStream( socket.getInputStream() ) ;
//
//			AbstractResponse response = (AbstractResponse) in.readObject();
//			socket.close();
//
//			if( response instanceof ReverseResponse )
//				return ((ReverseResponse) response).getTxet();
//			else {
//				System.out.println( "Unexpected response" );
//
//				return "";
//			}
//		} catch( Exception ex ) {
//			ex.printStackTrace();
//
//			return "";
//		}
//	}
//}