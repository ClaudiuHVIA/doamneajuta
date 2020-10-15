package Exercise11;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Server
{
  public static void main(String[] args)
  {
    new Server().run();
  }

  private void run()
  {
    try{
      ServerSocket serverSocket = new ServerSocket(33000);
      System.out.println( "Server listening on " + InetAddress.getLocalHost().getHostAddress() );
      while( true )
      {
        Socket clientSocket = serverSocket.accept();
        doWork( clientSocket );
      }
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
  }

  private void doWork( Socket clientSocket )
      throws Exception
  {
    BufferedReader in = new BufferedReader(
        new InputStreamReader( clientSocket.getInputStream() ) );

    OutputStreamWriter out =
        new OutputStreamWriter( clientSocket.getOutputStream() );

    String input = in.readLine();
    System.out.println( "RECEIVED: " + input );

    Thread.sleep( 3000 ); // wait 15 seconds to simulate work

    int inputInt = Integer.parseInt(input);
    int VAT = (25 * inputInt)/100;

    String output = String.valueOf(VAT);
    System.out.println( "SENDING: " + output );
    out.write( output );
    out.flush();

    clientSocket.close();
  }
}
