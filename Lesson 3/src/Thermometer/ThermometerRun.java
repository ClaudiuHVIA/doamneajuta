package Thermometer;

public class ThermometerRun
{
  public static void main(String[] args)
  {
    Thermometer t1 = new Thermometer("t1", 15);
    Thread th1 = new Thread(t1);
    th1.start();
  }
}
