package HeatingSystem.model.radiator;

import HeatingSystem.model.TemperatureModel;

public class Power3State implements RadiatorState
{
  private int POWER=3;
  private Thread th;

  public Power3State(Radiator radiator)
  {
    th = new Thread(()-> {
      try
      {
        Thread.sleep(5000);
        turnDown(radiator);
      }
      catch (InterruptedException e){}
    });
    th.start();
  }

  @Override public void turnUp(Radiator radiator)
  {}

  @Override public void turnDown(Radiator radiator)
  {
    th.interrupt();
    radiator.setPowerState(new Power2State());
  }

  @Override public int getPower()
  {
    return POWER;
  }
}
