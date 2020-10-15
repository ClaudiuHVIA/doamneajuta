package Burgers;

public class Monitor
{
  private int value;
  private boolean condition;

  public Monitor(int value, boolean condition)
  {
    this.value=value;
    this.condition=condition;
  }

  public synchronized void increment()
  {
    ++value;
  }

  public synchronized void decrement()
  {
    --value;
  }

  public synchronized void setCondition()
  {
    if(value<20)
    {
      condition = true;
    }
    if(value==20)
    {
      condition = false;
    }
  }

  public synchronized boolean getCondition()
  {
    return condition;
  }
}
