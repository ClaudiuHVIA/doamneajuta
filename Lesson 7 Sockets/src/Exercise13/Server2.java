package Exercise13;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server2
{
  public static void main(String[] args)
      throws IOException, ClassNotFoundException
  {
    ServerSocket serverSocket = new ServerSocket(5252);
    System.out.println("Server started");

    Socket client = serverSocket.accept();
    System.out.println("Client connected");

    ObjectInputStream inFromClient = new ObjectInputStream(client.getInputStream());
    ObjectOutputStream outToClient = new ObjectOutputStream(client.getOutputStream());

    outToClient.writeUnshared("Enter the RON amount that you want to convert to DKK: ");
    double amountFromClient = Double.parseDouble(inFromClient.readObject().toString());

    double dkk = amountFromClient * 0.639;

    outToClient.writeUnshared("Your converted amount is: " + dkk + "DKK");

    client.close();
  }
}
