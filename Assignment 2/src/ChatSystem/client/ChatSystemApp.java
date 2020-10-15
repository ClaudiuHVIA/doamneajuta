package ChatSystem.client;

import ChatSystem.client.core.ClientFactory;
import ChatSystem.client.core.ModelFactory;
import ChatSystem.client.core.ViewHandler;
import ChatSystem.client.core.ViewModelFactory;
import javafx.application.Application;
import javafx.stage.Stage;

public class ChatSystemApp extends Application
{
  @Override public void start(Stage stage) throws Exception
  {
    ClientFactory clientFactory = new ClientFactory();
    ModelFactory modelFactory = new ModelFactory(clientFactory);
    ViewModelFactory viewModelFactory = new ViewModelFactory(modelFactory);
    ViewHandler viewHandler = new ViewHandler(stage, viewModelFactory);
    viewHandler.start();
  }
}
