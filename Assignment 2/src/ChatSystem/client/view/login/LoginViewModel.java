package ChatSystem.client.view.login;

import ChatSystem.client.model.ClientChatModel;

public class LoginViewModel
{
  private ClientChatModel clientChatModel;

  public LoginViewModel(ClientChatModel clientChatModel)
  {
    this.clientChatModel = clientChatModel;
  }

  public void sendUsername(String username)
  {
    clientChatModel.sendUsername(username);
    System.out.println(username + " from loginViewModel");
  }
}
