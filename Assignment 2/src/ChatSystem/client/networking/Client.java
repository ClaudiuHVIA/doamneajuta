package ChatSystem.client.networking;

import ChatSystem.shared.util.PropertyChangeSubject;

public interface Client extends PropertyChangeSubject
{
  public void startClient();
  public void loginUsername(String username);
}
