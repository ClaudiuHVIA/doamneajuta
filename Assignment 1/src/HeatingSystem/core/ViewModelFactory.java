package HeatingSystem.core;

import HeatingSystem.view.heater.HeaterViewModel;
import HeatingSystem.view.temperature.TemperatureViewModel;

public class ViewModelFactory
{
  private TemperatureViewModel temperatureViewModel;
  private HeaterViewModel heaterViewModel;
  private ModelFactory modelFactory;

  public ViewModelFactory(ModelFactory modelFactory)
  {
    this.modelFactory = modelFactory;
  }

  public TemperatureViewModel getTemperatureViewModel()
  {
    if(temperatureViewModel == null)
    {
      temperatureViewModel = new TemperatureViewModel(modelFactory.getTemperatureModel());
    }
    return temperatureViewModel;
  }

  public HeaterViewModel getHeaterViewModel()
  {
    if(heaterViewModel == null)
    {
      heaterViewModel = new HeaterViewModel(modelFactory.getTemperatureModel());
    }
    return heaterViewModel;
  }
}
