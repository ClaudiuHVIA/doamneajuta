package ChatSystem.server;

import ChatSystem.shared.Message;

import java.util.ArrayList;
import java.util.List;

public class ConnectionPool
{
  private List<ChatServerHandler> connections = new ArrayList<>();

  public void addConnection(ChatServerHandler chatServerHandler)
  {
    connections.add(chatServerHandler);
  }

  public void removeConnection(ChatServerHandler chatServerHandler)
  {
    connections.remove(chatServerHandler);
  }

  public void broadcast(Message message)
  {
    for(ChatServerHandler connection : connections)
    {
      if(!connection.getClientName().equals(message.getUser()))
      {
        connection.sendMessageToClient(message);
      }
    }
  }
}
