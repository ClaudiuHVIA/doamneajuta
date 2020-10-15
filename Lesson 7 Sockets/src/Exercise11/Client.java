package Exercise11;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import static dk.via.jpe.simpletcp.SimpleTCPConfig.PORTNO;

public class Client
{
  public static void main(String[] args)
  {
    new Client().run();
  }

  private String ip;

  private void run()
  {
    ip = JOptionPane.showInputDialog( null, "IP address" );

    if( ip == null || ip.length() == 0 )
      return;

    String text = JOptionPane.showInputDialog( null, "Text" );
    while( text != null && text.length() > 0 )
    {
      String res = VAT( text );
      JOptionPane.showMessageDialog( null, res );

      text = JOptionPane.showInputDialog( null, "Text" );
    }
  }

  private String VAT (String text)
  {
    String result = "";

    try
    {
      Socket socket = new Socket(ip, 33000);

      BufferedReader in = new BufferedReader( new InputStreamReader( socket.getInputStream() ) );
      OutputStreamWriter out = new OutputStreamWriter( socket.getOutputStream() );

      out.write( text + "\n" ); // write to server
      out.flush();
      result = in.readLine(); // read from server

      socket.close();
    }
    catch (UnknownHostException e)
    {
      e.printStackTrace();
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }

    return result;
  }
}
