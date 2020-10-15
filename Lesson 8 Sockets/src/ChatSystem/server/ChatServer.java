package ChatSystem.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ChatServer
{
  public void start()
  {
    try
    {
      ServerSocket serverSocket = new ServerSocket(2424);
      ConnectionPool connectionPool = new ConnectionPool();
      System.out.println("Server started...");

      while (true)
      {
        Socket client = serverSocket.accept();

        ChatServerHandler chatServerHandler = new ChatServerHandler(client, connectionPool);
        connectionPool.addConnection(chatServerHandler);

        Thread thread = new Thread(chatServerHandler);
        thread.start();
      }
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
  }
}
