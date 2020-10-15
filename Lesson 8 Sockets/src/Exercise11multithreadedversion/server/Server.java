package Exercise11multithreadedversion.server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;



public class Server
{
  public void start()
  {
    System.out.println("Server starting...");

    try
    {
      ServerSocket serverSocket = new ServerSocket(2871);

      while (true)
      {
        Socket client = serverSocket.accept();
        System.out.println("Client connected");

        ServerHandler serverHandler = new ServerHandler(client);
        Thread thread = new Thread(serverHandler);
        thread.start();
      }
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
  }
}
