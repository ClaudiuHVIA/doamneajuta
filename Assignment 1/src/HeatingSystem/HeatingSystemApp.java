package HeatingSystem;

import HeatingSystem.core.ModelFactory;
import HeatingSystem.core.ViewHandler;
import HeatingSystem.core.ViewModelFactory;
import HeatingSystem.external.Thermometer;
import javafx.application.Application;
import javafx.stage.Stage;

public class HeatingSystemApp extends Application
{
  @Override public void start(Stage stage) throws Exception
  {
    ModelFactory modelFactory = new ModelFactory();
    ViewModelFactory viewModelFactory = new ViewModelFactory(modelFactory);
    ViewHandler viewHandler = new ViewHandler(stage, viewModelFactory);
    viewHandler.start();

    Thread outsideTemperature = new Thread(new Thermometer(0, 0, modelFactory.getTemperatureModel()));
    Thread insideTemperature1 = new Thread(new Thermometer(1, 5, modelFactory.getTemperatureModel()));
    Thread insideTemperature2 = new Thread(new Thermometer(2, 5, modelFactory.getTemperatureModel()));

    outsideTemperature.setDaemon(true);
    insideTemperature1.setDaemon(true);
    insideTemperature2.setDaemon(true);

    outsideTemperature.start();
    insideTemperature1.start();
    insideTemperature2.start();

  }
}
