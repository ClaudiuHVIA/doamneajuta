package Exercises.Clock;//package Exercises;

public class Clock
{
  private int seconds;

  public Clock ()
  {
    seconds = 0;
  }

  public Clock(int seconds)
  {
    this.seconds = seconds;
  }

  public int getSeconds()
  {
    return seconds;
  }

  public void increaseSeconds()
  {
    seconds++;
  }

  public void setSeconds(int seconds)
  {
    this.seconds = seconds;
  }
}
