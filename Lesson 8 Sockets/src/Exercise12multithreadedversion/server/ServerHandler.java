package Exercise12multithreadedversion.server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerHandler implements Runnable
{
  private final Socket client;
  private ObjectOutputStream outToClient;
  private ObjectInputStream inFromClient;

  public ServerHandler(Socket client)
  {
    this.client = client;
    try
    {
      outToClient = new ObjectOutputStream(client.getOutputStream());
      inFromClient = new ObjectInputStream(client.getInputStream());
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
  }

  private static boolean Prime(int givenNumber)
  {
    if(givenNumber == 1)
    {
      return false;
    }
    for(int i=2;i<=Math.sqrt(givenNumber);i++)
    {
      if(givenNumber % i == 0)
      {
        return false;
      }
    }
    return true;
  }

  private static String Reverse(String givenString)
  {
    String reverse = "";
    for(int i = givenString.length()-1;i>=0;i--)
    {
      reverse += givenString.charAt(i);
    }
    return reverse;
  }

  @Override public void run()
  {
    try
    {
      while(true)
      {
        outToClient.writeUnshared("Write 'string' for reversing or 'prime' for"
            + " checking your number or 'exit' for quitting");
        String messageFromClient = inFromClient.readObject().toString();
        if(messageFromClient.equalsIgnoreCase("exit"))
        {
          client.close();
          break;
        } else if(messageFromClient.equalsIgnoreCase("prime"))
        {
          outToClient.writeUnshared("Enter an integer");
          int givenNumber = Integer.parseInt(inFromClient.readObject().toString());
          outToClient.writeUnshared(Prime(givenNumber));
        } else if(messageFromClient.equalsIgnoreCase("string"))
        {
          outToClient.writeUnshared("Enter a string");
          String givenString = inFromClient.readObject().toString();
          outToClient.writeUnshared(Reverse(givenString));
        }
      }
    }
    catch (IOException | ClassNotFoundException e)
    {
      e.printStackTrace();
    }
  }
}
