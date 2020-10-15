package ChatSystem.client.view.login;

import ChatSystem.client.core.ViewHandler;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class LoginController
{
  private LoginViewModel loginViewModel;
  private ViewHandler viewHandler;

  public void init(LoginViewModel loginViewModel, ViewHandler viewHandler)
  {
    this.loginViewModel = loginViewModel;
    this.viewHandler = viewHandler;
  }

  @FXML public TextField loginUsernameId;

  @FXML
  public void loginButton(ActionEvent actionEvent)
  {
    loginViewModel.sendUsername(loginUsernameId.getText());
    System.out.println(loginUsernameId.getText() + " from loginController");
    viewHandler.openContactsView();
  }
}
