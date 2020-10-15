package Exercises.SleepCounter;

import java.util.Scanner;

public class StartCounter
{
  public static void main(String[] args)
  {
    Scanner keyboard = new Scanner(System.in);
    int x = keyboard.nextInt();
    Thread t1 = new Thread(new UpdateCounter(x));
    t1.start();
  }
}
