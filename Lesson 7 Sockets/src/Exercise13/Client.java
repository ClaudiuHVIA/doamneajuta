package Exercise13;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client
{
  public static void main(String[] args)
      throws IOException, ClassNotFoundException
  {
    Scanner keyboard = new Scanner(System.in);
    System.out.println("Write 1 for choosing the server for EUR or 2 for choosing"
        + " the one for RON");
    int clientChooses = keyboard.nextInt();
    if(clientChooses == 1)
    {
      System.out.println("Enters if statement on 1");
      keyboard.nextLine();
      Socket socket = new Socket("localhost", 2525);

      ObjectOutputStream outToServer = new ObjectOutputStream(socket.getOutputStream());
      ObjectInputStream inFromServer = new ObjectInputStream(socket.getInputStream());

      String messageFromServer = inFromServer.readObject().toString();
      System.out.println(messageFromServer);

      System.out.println("it should let you enter the amount");
      String message = keyboard.nextLine();
      outToServer.writeUnshared(message);

      messageFromServer = inFromServer.readObject().toString();
      System.out.println(messageFromServer);
    } else if(clientChooses == 2)
    {
      System.out.println("Enters if statement on 2");
      keyboard.nextLine();
      Socket socket = new Socket("localhost", 5252);

      ObjectOutputStream outToServer = new ObjectOutputStream(socket.getOutputStream());
      ObjectInputStream inFromServer = new ObjectInputStream(socket.getInputStream());

      String messageFromServer = inFromServer.readObject().toString();
      System.out.println(messageFromServer);

      String message = keyboard.nextLine();
      outToServer.writeUnshared(message);

      messageFromServer = inFromServer.readObject().toString();
      System.out.println(messageFromServer);
    }
  }
}
