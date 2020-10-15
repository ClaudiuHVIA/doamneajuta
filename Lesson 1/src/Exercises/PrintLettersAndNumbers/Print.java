package Exercises.PrintLettersAndNumbers;

import java.util.Scanner;

public class Print
{
  public static void main(String[] args)
  {
    Scanner keyboard = new Scanner(System.in);
    int number = keyboard.nextInt();
    Thread t1 = new Thread(new Letters(number));
    Thread t2 = new Thread(new Numbers(number));
    t1.start();
    t2.start();
  }
}
