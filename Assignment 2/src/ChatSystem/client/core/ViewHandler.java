package ChatSystem.client.core;

import ChatSystem.client.view.chat.ChatController;
import ChatSystem.client.view.contacts.ContactsController;
import ChatSystem.client.view.login.LoginController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ViewHandler
{
  private Stage stage;
  private Scene loginScene;
  private Scene contactsScene;
  private Scene chatScene;
  private ViewModelFactory viewModelFactory;

  public ViewHandler(Stage stage, ViewModelFactory viewModelFactory)
  {
    this.stage = stage;
    this.viewModelFactory = viewModelFactory;
  }

  private Parent getRootByPath(String path, FXMLLoader loader)
  {
    loader.setLocation(getClass().getResource(path));
    Parent root = null;

    try{
      root = loader.load();
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
    return root;
  }

  public void openLoginView()
  {
    FXMLLoader loader = new FXMLLoader();

    if(loginScene == null)
    {
      Parent root = getRootByPath("../view/login/Login.fxml", loader);
      LoginController controller = loader.getController();
      controller.init(viewModelFactory.getLoginViewModel(), this);
      loginScene = new Scene(root);
    }

    stage.setTitle("Login");
    stage.setScene(loginScene);
  }

  public void openContactsView()
  {
    FXMLLoader loader = new FXMLLoader();

    if(contactsScene == null)
    {
      Parent root = getRootByPath("../view/contacts/Contacts.fxml", loader);
      ContactsController controller = loader.getController();
      controller.init(viewModelFactory.getContactsViewModel(), this);
      contactsScene = new Scene(root);
    }

    stage.setTitle("Contacts");
    stage.setScene(contactsScene);
  }

  public void openChatView()
  {
    FXMLLoader loader = new FXMLLoader();

    if(chatScene == null)
    {
      Parent root = getRootByPath("../view/chat/Chat.fxml", loader);
      ChatController controller = loader.getController();
      controller.init(viewModelFactory.getChatViewModel(), this);
      chatScene = new Scene(root);
    }

    stage.setTitle("Chat");
    stage.setScene(chatScene);
  }

  public void start()
  {
    openLoginView();
    stage.show();
  }

}
