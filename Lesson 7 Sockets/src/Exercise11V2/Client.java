package Exercise11V2;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Client
{
  public static void main(String[] args)
      throws IOException, ClassNotFoundException
  {
    Socket socket = new Socket("localhost", 5555);
    Scanner input = new Scanner(System.in);

    ObjectOutputStream outToServer = new ObjectOutputStream(socket.getOutputStream());
    ObjectInputStream inFromServer = new ObjectInputStream(socket.getInputStream());

    String messageFromServer = (String) inFromServer.readObject();
    System.out.println(messageFromServer);

    double amount = input.nextDouble();
    outToServer.writeUnshared(amount);

    messageFromServer = (String) inFromServer.readObject();
    System.out.println(messageFromServer);
  }
}
