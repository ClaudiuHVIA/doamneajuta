package Exercises.PrintLettersAndNumbers;

public class Letters implements Runnable
{
  private int letterNo;

  public Letters(int letterNo)
  {
    this.letterNo = letterNo;
  }

  @Override public void run()
  {
    while(true)
    {
      for(int i=0;i<letterNo;i++)
      {
        System.out.println((char)(97+i));
      }
    }
  }
}
