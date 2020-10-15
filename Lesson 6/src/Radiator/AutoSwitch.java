package Radiator;

public class AutoSwitch implements Runnable
{
  private Radiator radiator;

  public AutoSwitch(Radiator radiator)
  {
    this.radiator=radiator;
  }

  @Override public void run()
  {
    try
    {
      Thread.sleep(5000);
      radiator.turnDown();
      System.out.println("radiator automatically turned to 2");
    }
    catch (InterruptedException e){}
  }
}
