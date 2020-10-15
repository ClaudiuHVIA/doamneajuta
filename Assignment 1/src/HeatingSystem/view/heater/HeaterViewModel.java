package HeatingSystem.view.heater;

import HeatingSystem.model.TemperatureModel;
import javafx.application.Platform;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.beans.PropertyChangeEvent;

public class HeaterViewModel
{
  private StringProperty powerState;
  private TemperatureModel temperatureModel;

  public HeaterViewModel(TemperatureModel temperatureModel)
  {
    this.temperatureModel = temperatureModel;
    powerState = new SimpleStringProperty();
    powerState.setValue("0");
    this.temperatureModel.addPropertyListener("PowerChanged", evt -> update(evt) );
  }

  public void increase()
  {
    temperatureModel.increasePowerState();
  }

  public void decrease()
  {
    temperatureModel.decreasePowerState();
  }

  public void update(PropertyChangeEvent evt)
  {
    Platform.runLater(() -> {
      int newTemp = (int) evt.getNewValue();
      powerState.setValue(String.valueOf(newTemp));
    });
  }

  public StringProperty getPowerState()
  {
    return powerState;
  }
}
