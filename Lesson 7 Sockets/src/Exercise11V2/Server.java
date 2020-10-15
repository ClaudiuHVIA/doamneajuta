package Exercise11V2;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server
{
  public static void main(String[] args)
      throws IOException, ClassNotFoundException
  {
    ServerSocket serverSocket = new ServerSocket(5555);
    System.out.println("Server started");

    Socket client = serverSocket.accept();
    System.out.println("Client connected");

    ObjectInputStream inFromClient = new ObjectInputStream(client.getInputStream());
    ObjectOutputStream outToClient = new ObjectOutputStream(client.getOutputStream());

    outToClient.writeUnshared("Enter an amount");

    double amountFromClient = (double) inFromClient.readObject();

    double vat = amountFromClient * 0.25;

    outToClient.writeUnshared("The VAT is: " + vat);

    client.close();
  }
}
