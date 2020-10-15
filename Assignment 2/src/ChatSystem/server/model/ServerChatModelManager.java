package ChatSystem.server.model;

import ChatSystem.shared.transferedObjects.RequestType;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;

public class ServerChatModelManager implements ServerChatModel
{
  private PropertyChangeSupport support;
  private ArrayList<String> users;

  public ServerChatModelManager()
  {
    support = new PropertyChangeSupport(this);
    users = new ArrayList<>();
  }

  @Override public void newUser(String username)
  {
    users.add(username);
    support.firePropertyChange(RequestType.GETUSERS.toString(), null, new ArrayList<>(users));
  }

  @Override public ArrayList<String> getUsers()
  {
    return users;
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
