package ChatSystem.client.model;

import ChatSystem.shared.util.PropertyChangeSubject;

import java.beans.PropertyChangeEvent;
import java.util.ArrayList;

public interface ClientChatModel extends PropertyChangeSubject
{
  public void sendUsername(String username);
  public void getUsers(PropertyChangeEvent propertyChangeEvent);
}
