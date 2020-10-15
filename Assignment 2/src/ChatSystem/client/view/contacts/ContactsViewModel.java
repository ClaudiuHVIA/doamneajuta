package ChatSystem.client.view.contacts;

import ChatSystem.client.model.ClientChatModel;
import ChatSystem.shared.transferedObjects.RequestType;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;


public class ContactsViewModel
{
  private ClientChatModel clientChatModel;
  private ObservableList<String> users;

  public ContactsViewModel(ClientChatModel clientChatModel)
  {
    this.clientChatModel = clientChatModel;
    clientChatModel.addPropertyListener(RequestType.GETUSERS.toString(), this::usersList);
  }

  public void usersList(PropertyChangeEvent propertyChangeEvent)
  {
    System.out.println("inside method ");
    System.out.println(propertyChangeEvent.getNewValue().toString() + "from contactsViewModel");
    users = FXCollections.observableArrayList(propertyChangeEvent.getNewValue().toString());
  }

  public ObservableList<String> getUsers()
  {
    return users;
  }

  public void connectToUser()
  {}


}
