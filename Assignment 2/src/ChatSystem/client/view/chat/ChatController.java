package ChatSystem.client.view.chat;

import ChatSystem.client.core.ViewHandler;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class ChatController
{
  @FXML public Label chatUsernameId;
  @FXML public ListView chatListViewId;
  @FXML public TextField chatMessageId;

  public void init(ChatViewModel chatViewModel, ViewHandler viewHandler)
  {
  }

  @FXML
  public void chatBackButton(ActionEvent actionEvent)
  {
  }

  @FXML
  public void chatSendButton(ActionEvent actionEvent)
  {
  }
}
