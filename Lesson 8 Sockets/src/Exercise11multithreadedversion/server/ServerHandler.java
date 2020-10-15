package Exercise11multithreadedversion.server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ServerHandler implements Runnable
{
  private final Socket client;
  private ObjectInputStream inFromClient;
  private ObjectOutputStream outToClient;

  public ServerHandler(Socket client)
  {
    this.client = client;
    try
    {
      inFromClient = new ObjectInputStream(client.getInputStream());
      outToClient = new ObjectOutputStream(client.getOutputStream());
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
  }

  @Override public void run()
  {
      try
      {
        while (true)
        {
        outToClient.writeUnshared("Enter an integer to calculate VAT");
        String read = (String) inFromClient.readObject();
        if(read.equalsIgnoreCase("exit"))
        {
          client.close();
          break;
        }
        int vat = (25 * Integer.parseInt(read))/100;
        outToClient.writeUnshared(vat);

      }
      }
      catch (IOException | ClassNotFoundException e)
      {
        e.printStackTrace();
      }
  }
}
