package ChatSystem.client;

import ChatSystem.shared.Message;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class ChatClient
{
  private ObjectInputStream inFromServer;
  private Socket client;

  public void listenToServer()
  {

    try
    {
      while(true)
      {
        Message response = (Message) inFromServer.readObject();
        if(response.getMessageBody().equalsIgnoreCase("exit"))
        {
          client.close();
          break;
        }
        System.out.println(response);
      }
    } catch (IOException | ClassNotFoundException e)
   {
      e.printStackTrace();
   }
  }

  public void startClient()
  {
    try
    {
      client = new Socket("localhost", 2424);
      ObjectOutputStream outToServer = new ObjectOutputStream(client.getOutputStream());
      inFromServer = new ObjectInputStream(client.getInputStream());

      Thread thread = new Thread(this :: listenToServer);
      thread.start();

      Scanner keyboard = new Scanner(System.in);
      System.out.println("Insert user name: ");

      String userName = keyboard.nextLine();
      outToServer.writeObject(userName);

      while(true)
      {
        System.out.println("Input: ");
        String writeMessage = keyboard.nextLine();
        Message message = new Message(userName, writeMessage);
        outToServer.writeObject(message);

        if(writeMessage.equalsIgnoreCase("exit"))
        {
          break;
        }
      }
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
  }
}
