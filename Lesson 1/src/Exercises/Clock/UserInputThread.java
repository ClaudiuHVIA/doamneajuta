package Exercises.Clock;//package Exercises;

import java.util.Scanner;

public class UserInputThread implements Runnable
{
  private int inputedSeconds;
  private Clock clock;
  private  Thread timerThread;

  public UserInputThread(Clock clock)
  {
    this.clock = clock;
    this.timerThread = new Thread(new TimerThread(clock));
    timerThread.setDaemon(true);
    timerThread.start();
  }

  public void askForInput()
  {
    Scanner scan = new Scanner(System.in);
    if (scan.hasNext())
    {
      inputedSeconds = scan.nextInt();
      System.out.println("Read");
    }
  }

  @Override public void run()
  {
    boolean flag = true;
    while (flag)
    {
      askForInput();
      clock.setSeconds(inputedSeconds);
      if(inputedSeconds == 0)
      {
        flag = false;
      }
    }
  }
}
