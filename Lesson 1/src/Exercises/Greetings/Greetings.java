package Exercises.Greetings;

public class Greetings
{
  public static void main(String[] args)
  {
    Thread hi = new Thread(new PrintGreetings("hi"));
    Thread hello = new Thread(new PrintGreetings("hello"));

    hi.start();
    hello.start();
  }
}
