package ChatSystem.client.view.contacts;

import ChatSystem.client.core.ViewHandler;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;

public class ContactsController
{
  @FXML public ListView contactsListViewId;

  private ContactsViewModel contactsViewModel;
  private ViewHandler viewHandler;

  public void init(ContactsViewModel contactsViewModel, ViewHandler viewHandler)
  {
    this.contactsViewModel = contactsViewModel;
    this.viewHandler = viewHandler;
    contactsListViewId.setItems(contactsViewModel.getUsers());
  }

  @FXML
  public void backToLogin(ActionEvent actionEvent)
  {
  }


}
