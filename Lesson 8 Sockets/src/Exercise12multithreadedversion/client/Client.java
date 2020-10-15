package Exercise12multithreadedversion.client;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client
{
  public void startClient()
  {
    //connect to server
    try
    {
      Socket client = new Socket("localhost", 3110);
      System.out.println("Connected");
      ObjectInputStream inFromServer = new ObjectInputStream(client.getInputStream());
      ObjectOutputStream outToServer = new ObjectOutputStream(client.getOutputStream());
      Scanner keyboard = new Scanner(System.in);
      String messageFromServer, messageToServer;
      while(true)
      {
        messageFromServer = inFromServer.readObject().toString();
        System.out.println(messageFromServer);
        messageToServer = keyboard.nextLine();
        outToServer.writeUnshared(messageToServer);
        if(messageToServer.equalsIgnoreCase("exit"))
        {
          client.close();
          break;
        }
        messageFromServer = inFromServer.readObject().toString();
        System.out.println(messageFromServer);
        messageToServer = keyboard.nextLine();
        outToServer.writeUnshared(messageToServer);
        if(messageToServer.equalsIgnoreCase("exit"))
        {
          client.close();
          break;
        }
        messageFromServer = inFromServer.readObject().toString();
        System.out.println(messageFromServer);
      }
    }
    catch (IOException | ClassNotFoundException e)
    {
      e.printStackTrace();
    }
  }
}
