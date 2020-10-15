package HeatingSystem.core;

import HeatingSystem.view.heater.HeaterController;
import HeatingSystem.view.temperature.TemperatureController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ViewHandler
{
  private Stage mainStage;
  private Scene temperatureViewScene;
  private Scene heaterViewScene;

  private ViewModelFactory viewModelFactory;

  public ViewHandler(Stage stage, ViewModelFactory viewModelFactory)
  {
    mainStage = stage;
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

  public void openTemperatureView()
  {
    FXMLLoader loader = new FXMLLoader();

    if(temperatureViewScene == null)
    {
      Parent root = getRootByPath("../view/temperature/Temperature.fxml", loader);
      TemperatureController controller = loader.getController();
      controller.init(viewModelFactory.getTemperatureViewModel(), this);
      temperatureViewScene = new Scene(root);
    }

    mainStage.setTitle("View temperature");
    mainStage.setScene(temperatureViewScene);
  }

  public void openHeaterView()
  {
    FXMLLoader loader = new FXMLLoader();

    if(heaterViewScene == null)
    {
      Parent root = getRootByPath("../view/heater/Heater.fxml", loader);
      HeaterController controller = loader.getController();
      controller.init(viewModelFactory.getHeaterViewModel(), this);
      heaterViewScene = new Scene(root);
    }

    mainStage.setTitle("View heater");
    mainStage.setScene(heaterViewScene);
  }

  public void start()
  {
    openTemperatureView();
    mainStage.show();
  }
}
