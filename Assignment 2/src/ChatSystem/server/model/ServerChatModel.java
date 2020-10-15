package ChatSystem.server.model;

import ChatSystem.shared.util.PropertyChangeSubject;

import java.util.ArrayList;

public interface ServerChatModel extends PropertyChangeSubject
{
  public void newUser(String username);
  public ArrayList<String> getUsers();
}
