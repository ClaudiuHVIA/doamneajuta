package Radiator;

public class Power3State implements RadiatorState
{
  private int POWER=3;
  private Thread th;
  private Thread th1;

  public Power3State(Radiator radiator)
  {
    AutoSwitch autoSwitch = new AutoSwitch(radiator);
    th = new Thread(autoSwitch);
    th1 = new Thread(()-> {
      try
      {
        Thread.sleep(5000);
        radiator.turnDown();
        System.out.println("radiator automatically turned to 2");
      }
      catch (InterruptedException e){}
    });
    th1.start();
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
