package Exercise12;

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
    Socket socket = new Socket("localhost", 10000);
    Scanner input = new Scanner(System.in);

    ObjectOutputStream outToServer = new ObjectOutputStream(socket.getOutputStream());
    ObjectInputStream inFromServer = new ObjectInputStream(socket.getInputStream());

    while(true)
    {
      String messageFromServer = inFromServer.readObject().toString();
      System.out.println(messageFromServer);

      String message = input.nextLine();
      outToServer.writeUnshared(message);
    }
  }
}
