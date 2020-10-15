package ChatSystem.server;

import ChatSystem.shared.Message;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ChatServerHandler implements Runnable
{
  private Socket client;
  private ConnectionPool connectionPool;
  private ObjectOutputStream outToClient;
  private ObjectInputStream inFromClient;
  private String userName;

  public ChatServerHandler(Socket client, ConnectionPool connectionPool)
  {
    this.client = client;
    this.connectionPool = connectionPool;
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

  public void sendMessageToClient(Message message)
  {
    try
    {
      outToClient.writeObject(message);
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
  }

  public String getClientName()
  {
    return userName;
  }

  @Override public void run()
  {
    try
    {
      userName = (String) inFromClient.readObject();

      while(true)
      {
        Message message = (Message) inFromClient.readObject();
        System.out.println(message);
        if(message.getMessageBody().equalsIgnoreCase("exit"))
        {
          connectionPool.removeConnection(this);
          outToClient.writeObject(message);
          client.close();
          break;
        }
        connectionPool.broadcast(message);
      }
    }
    catch (IOException | ClassNotFoundException e)
    {
      e.printStackTrace();
    }
  }
}
