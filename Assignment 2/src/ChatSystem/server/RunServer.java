package ChatSystem.server;

import ChatSystem.server.model.ServerChatModelManager;
import ChatSystem.server.networking.SocketServer;

public class RunServer
{
  public static void main(String[] args) {

    SocketServer ss = new SocketServer(new ServerChatModelManager());
    ss.startServer();
  }
}
