package Exercise11multithreadedversion.client;

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
      Socket client = new Socket("localhost", 2871);
      System.out.println("Connected");
      ObjectOutputStream outToServer = new ObjectOutputStream(client.getOutputStream());
      ObjectInputStream inFromServer = new ObjectInputStream(client.getInputStream());

      while(true)
      {
        String messageFromServer = (String) inFromServer.readObject();
        System.out.println(messageFromServer);
        //send message to server
        Scanner keyboard = new Scanner(System.in);
        String messageToServer = keyboard.nextLine();
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
