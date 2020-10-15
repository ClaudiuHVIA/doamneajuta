package Exercises.Greetings;

public class PrintGreetings implements Runnable
{
  private String greeting;

  public PrintGreetings(String greeting)
  {
    this.greeting = greeting;
  }

  @Override public void run()
  {
    for(int i=0;i<100;i++)
    {
      System.out.println(greeting);
    }
  }
}
