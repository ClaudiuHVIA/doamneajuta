package Exercises.WatchProgram;

public class Clock
{
  private int seconds;
  private int minutes;
  private int hours;

  public Clock(int hours, int minutes, int seconds)
  {
    this.hours = hours;
    this.minutes = minutes;
    this.seconds = seconds;
  }

  public void setHours(int hours)
  {
    this.hours = hours;
  }

  public void setMinutes(int minutes)
  {
    this.minutes = minutes;
  }

  public void setSeconds(int seconds)
  {
    this.seconds = seconds;
  }

  public int getHours()
  {
    return hours;
  }

  public int getMinutes()
  {
    return minutes;
  }

  public int getSeconds()
  {
    return seconds;
  }

  public void tic()
  {
    seconds+=10;
    if(seconds>=60)
    {
      seconds = 60 - seconds;
      minutes++;
    }
    if(minutes==60)
    {
      minutes=0;
      hours++;
    }
    if(hours==24)
    {
      hours=0;
    }
  }

  public String toString()
  {
    return hours + ":" +
        minutes + ":" +
        seconds;
  }
}
