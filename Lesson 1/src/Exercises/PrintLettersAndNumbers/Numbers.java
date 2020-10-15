package Exercises.PrintLettersAndNumbers;

public class Numbers implements Runnable
{
  private int number;

  public Numbers(int number)
  {
    this.number = number;
  }

  @Override public void run()
  {
    while (true)
    {
      for(int i=0;i<number;i++)
      {
        System.out.println(i);
      }
    }

  }
}
