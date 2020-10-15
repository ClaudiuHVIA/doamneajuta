package ChatSystem.server.networking;

import ChatSystem.server.model.ServerChatModel;
import ChatSystem.shared.transferedObjects.Request;
import ChatSystem.shared.transferedObjects.RequestType;

import java.beans.PropertyChangeEvent;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class SocketServerHandler implements Runnable
{
  private Socket socket;
  private ServerChatModel serverChatModel;

  private ObjectOutputStream outToClient;
  private ObjectInputStream inFromClient;

  public SocketServerHandler(Socket socket, ServerChatModel serverChatModel)
  {
    this.socket = socket;
    this.serverChatModel = serverChatModel;
    try
    {
      outToClient = new ObjectOutputStream(socket.getOutputStream());
      inFromClient = new ObjectInputStream(socket.getInputStream());
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
      Request request = (Request) inFromClient.readObject();
      if(RequestType.LISTENER.equals(request.getType()))
      {
        serverChatModel.addPropertyListener(RequestType.GETUSERS.toString(), this::getUsers);
      } else if(RequestType.USERNAME.equals(request.getType()))
      {
        serverChatModel.newUser(request.getArgument().toString());
      }
    }
    catch (IOException | ClassNotFoundException e)
    {
      e.printStackTrace();
    }
  }

  private void getUsers(PropertyChangeEvent propertyChangeEvent)
  {
    try
    {
      System.out.println(serverChatModel.getUsers().toString() + " from socketServerHandler plm");
      outToClient.writeUnshared(new Request(RequestType.GETUSERS, serverChatModel.getUsers()));
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
  }

}
