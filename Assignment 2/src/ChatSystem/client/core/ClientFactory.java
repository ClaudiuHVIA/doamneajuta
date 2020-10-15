package ChatSystem.client.core;

import ChatSystem.client.networking.Client;
import ChatSystem.client.networking.SocketClient;

public class ClientFactory
{
  private Client client;

  public Client getClient()
  {
    if(client == null)
    {
      client = new SocketClient();
    }
    return client;
  }
}
