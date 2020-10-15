package Exercise12multithreadedversion.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server
{

  public void start()
  {
    System.out.println("Server starting...");
    try
    {
      ServerSocket serverSocket = new ServerSocket(3110);

      while (true)
      {
        Socket client = serverSocket.accept();
        System.out.println("Connected");
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
