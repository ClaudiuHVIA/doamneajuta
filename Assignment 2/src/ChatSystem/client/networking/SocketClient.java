package ChatSystem.client.networking;

import ChatSystem.shared.transferedObjects.Request;
import ChatSystem.shared.transferedObjects.RequestType;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class SocketClient implements Client
{
  private PropertyChangeSupport support;

  public SocketClient()
  {
    support = new PropertyChangeSupport(this);
  }

  @Override public void startClient()
  {
    try
    {
      Socket socket = new Socket("localhost", 2410);
      ObjectOutputStream outToServer = new ObjectOutputStream(socket.getOutputStream());
      ObjectInputStream inFromServer = new ObjectInputStream(socket.getInputStream());
      new Thread(() -> listenToServer(outToServer, inFromServer)).start();
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
  }

  private void listenToServer(ObjectOutputStream outToServer, ObjectInputStream inFromServer)
  {
    try
    {
      outToServer.writeObject(new Request(RequestType.LISTENER, null));
      while(true)
      {
        Request request = (Request) inFromServer.readObject();
        System.out.println(request.getArgument().toString() + " from SocketClient");
        support.firePropertyChange(request.getType().toString(), null, request.getArgument());
      }
    }
    catch (IOException | ClassNotFoundException e)
    {
      e.printStackTrace();
    }
  }

  @Override public void loginUsername(String username)
  {
    try
    {
      Socket socket = new Socket("localhost", 2410);
      ObjectOutputStream outToServer = new ObjectOutputStream(socket.getOutputStream());
      ObjectInputStream inFromServer = new ObjectInputStream(socket.getInputStream());
      outToServer.writeObject(new Request(RequestType.USERNAME, username));
      System.out.println(username + " from SocketClient");
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
  }

  @Override public void addPropertyListener(PropertyChangeListener listener)
  {
    support.addPropertyChangeListener(listener);
  }

  @Override public void addPropertyListener(String eventName,
      PropertyChangeListener listener)
  {
    if(eventName == null)
    {
      support.addPropertyChangeListener(listener);
    } else {
      support.addPropertyChangeListener(eventName, listener);
    }
  }

  @Override public void removePropertyListener(PropertyChangeListener listener)
  {
    support.removePropertyChangeListener(listener);
  }

  @Override public void removePropertyListener(String eventName,
      PropertyChangeListener listener)
  {
    if(eventName == null)
    {
      support.removePropertyChangeListener(listener);
    } else {
      support.addPropertyChangeListener(eventName, listener);
    }
  }
}
