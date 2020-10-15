package Exercises.Clock;//package Exercises;

public class Main
{
  public static void main(String[] args)
  {
    Clock clock = new Clock();
    Thread userInputThread = new Thread(new UserInputThread(clock));
    userInputThread.start();

  }
}
