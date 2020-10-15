package HeatingSystem.core;

import HeatingSystem.model.TemperatureModel;
import HeatingSystem.model.TemperatureModelManager;

public class ModelFactory
{
  private TemperatureModel temperatureModel;

  public TemperatureModel getTemperatureModel()
  {
    if(temperatureModel == null)
    {
      temperatureModel = new TemperatureModelManager();
    }
    return temperatureModel;
  }
}
