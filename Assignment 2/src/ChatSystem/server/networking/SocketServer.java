package ChatSystem.server.networking;

import ChatSystem.server.model.ServerChatModel;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServer
{
  private ServerChatModel serverChatModel;

  public SocketServer(ServerChatModel serverChatModel)
  {
    this.serverChatModel = serverChatModel;
  }

  public void startServer()
  {
    try
    {
      ServerSocket welcomeSocket = new ServerSocket(2410);

      while(true)
      {
        Socket socket = welcomeSocket.accept();
        new Thread (new SocketServerHandler(socket, serverChatModel)).start();
      }
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
  }
}
