package HeatingSystem.view.temperature;

import HeatingSystem.model.TemperatureModel;
import javafx.application.Platform;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.beans.PropertyChangeEvent;

public class TemperatureViewModel
{
  private StringProperty outsideTemperature;
  private StringProperty insideTemperature1;
  private StringProperty insideTemperature2;
  private StringProperty critical;
  private TemperatureModel temperatureModel;


  public TemperatureViewModel(TemperatureModel temperatureModel)
  {
    this.temperatureModel = temperatureModel;
    outsideTemperature = new SimpleStringProperty();
    insideTemperature1 = new SimpleStringProperty();
    insideTemperature2 = new SimpleStringProperty();
    critical = new SimpleStringProperty();
    this.temperatureModel.addPropertyListener("OutsideTemperature", evt -> updateTemperature(0, evt));
    this.temperatureModel.addPropertyListener("InsideTemperature1", evt -> updateTemperature(1, evt));
    this.temperatureModel.addPropertyListener("InsideTemperature2", evt -> updateTemperature(2, evt));
    this.temperatureModel.addPropertyListener("Critical", evt -> updateCritical(evt));
  }

  private void updateTemperature(int id, PropertyChangeEvent evt)
  {
    if(id == 0)
    {
      Platform.runLater(() -> {
        double newOutsideTemp = (double) evt.getNewValue();
        outsideTemperature.setValue(String.format("%6.2f",newOutsideTemp));
      });
    } else
      if(id == 1)
      {
        Platform.runLater(() -> {
          double newInsideTemp1 = (double) evt.getNewValue();
          insideTemperature1.setValue(String.format("%6.2f",newInsideTemp1));
        });
      } else
        if(id == 2)
        {
          Platform.runLater(() -> {
            double newInsideTemp2 = (double) evt.getNewValue();
            insideTemperature2.setValue(String.format("%6.2f",newInsideTemp2));
          });
        }
  }

  private void updateCritical(PropertyChangeEvent evt)
  {
    Platform.runLater(() -> {
      String newAnnouncement = (String) evt.getNewValue();
      critical.setValue(newAnnouncement);
    });
  }

  public StringProperty getOutsideTemperature()
  {
    return outsideTemperature;
  }

  public StringProperty getInsideTemperature1()
  {
    return insideTemperature1;
  }

  public StringProperty getInsideTemperature2()
  {
    return insideTemperature2;
  }

  public StringProperty getCritical() { return critical; }

}
