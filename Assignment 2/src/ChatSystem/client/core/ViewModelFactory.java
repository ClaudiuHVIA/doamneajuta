package ChatSystem.client.core;

import ChatSystem.client.view.chat.ChatViewModel;
import ChatSystem.client.view.contacts.ContactsViewModel;
import ChatSystem.client.view.login.LoginViewModel;

public class ViewModelFactory
{
  private final ModelFactory modelFactory;
  private LoginViewModel loginViewModel;
  private ContactsViewModel contactsViewModel;
  private ChatViewModel chatViewModel;

  public ViewModelFactory(ModelFactory modelFactory)
  {
    this.modelFactory = modelFactory;
  }

  public LoginViewModel getLoginViewModel()
  {
    if(loginViewModel == null)
    {
      loginViewModel = new LoginViewModel(modelFactory.getClientChatModel());
    }
    return loginViewModel;
  }

  public ContactsViewModel getContactsViewModel()
  {
    if(contactsViewModel == null)
    {
      contactsViewModel = new ContactsViewModel(modelFactory.getClientChatModel());
    }
    return contactsViewModel;
  }

  public ChatViewModel getChatViewModel()
  {
    if(chatViewModel == null)
    {
      chatViewModel = new ChatViewModel(modelFactory.getClientChatModel());
    }
    return chatViewModel;
  }
}
