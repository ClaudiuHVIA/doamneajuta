package HeatingSystem.external;

import HeatingSystem.model.TemperatureModel;

public class Thermometer implements Runnable
{
  private int id;
  private double t;
  private final TemperatureModel temperatureModel;

  public Thermometer(int id, double t, TemperatureModel temperatureModel)
  {
    this.id = id;
    this.t = t;
    this.temperatureModel = temperatureModel;
  }

  private double internalTemperature(double t, int p, int d, double t0, int s)
  {
    double tMax = Math.min(11 * p + 10, 11 * p + 10 + t0);

    tMax = Math.max(Math.max(t, tMax), t0);

    double heaterTerm = 0;

    if (p > 0)

    {

      double den = Math.max((tMax * (20 - 5 * p) * (d + 5)), 0.1);

      heaterTerm = 30 * s * Math.abs(tMax - t) / den;

    }

    double outdoorTerm = (t - t0) * s / 250.0;

    t = Math.min(Math.max(t - outdoorTerm + heaterTerm, t0), tMax);

    return t;
  }

  private double externalTemperature(double t0, double min, double max)
  {
    double left = t0 - min;
    double right = max - t0;
    int sign = Math.random() * (left + right) > left ? 1 : -1;
    t0 += sign * Math.random();
    return t0;
  }

  @Override public void run()
  {
    if(id == 0)
    {
      while(true)
      {
        t = externalTemperature(t, -20, 20);
        temperatureModel.setTemperature(0, t);
        try
        {
          Thread.sleep(5000);
        }
        catch (InterruptedException e)
        {}
      }
    } else
    if(id == 1)
    {
      while(true)
      {
        t = internalTemperature(t, temperatureModel.getRadiatorPowerState(), 1,
            temperatureModel.getOutsideTemperature(), 6);
        temperatureModel.setTemperature(1, t);
        try
        {
          Thread.sleep(3000);
        }
        catch (InterruptedException e)
        {}
      }
    } else
      if(id == 2)
      {
        while (true)
        {
          t = internalTemperature(t, temperatureModel.getRadiatorPowerState(), 7,
              temperatureModel.getOutsideTemperature(), 6);
          temperatureModel.setTemperature(2, t);
          try
          {
            Thread.sleep(2000);
          }
          catch (InterruptedException e)
          {}
        }
      }
  }
}
