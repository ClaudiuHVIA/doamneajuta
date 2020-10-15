package ChatSystem.client.model;

import ChatSystem.client.networking.Client;
import ChatSystem.shared.transferedObjects.RequestType;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;

public class ClientChatModelManager implements ClientChatModel
{
  private Client client;
  private PropertyChangeSupport support;


  private ArrayList<String> usersTest;

  public ClientChatModelManager(Client client)
  {
    this.client = client;
    support = new PropertyChangeSupport(this);
    client.startClient();
    client.addPropertyListener(RequestType.GETUSERS.toString(), this::getUsers);
    usersTest = new ArrayList<>();
  }


  @Override public void getUsers(PropertyChangeEvent propertyChangeEvent)
  {
    System.out.println(propertyChangeEvent.getNewValue().toString() + " from ClientChatModelManager");
    support.firePropertyChange(propertyChangeEvent);
    usersTest = (ArrayList<String>) propertyChangeEvent.getNewValue();
    System.out.println(usersTest + " the arraylist from manager");
  }

  @Override public void sendUsername(String username)
  {
    client.loginUsername(username);
    System.out.println(username + " from clientChatModelManager");
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
