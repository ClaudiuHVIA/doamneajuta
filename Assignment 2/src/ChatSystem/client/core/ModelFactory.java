package ChatSystem.client.core;

import ChatSystem.client.model.ClientChatModel;
import ChatSystem.client.model.ClientChatModelManager;

public class ModelFactory
{
  private final ClientFactory clientFactory;
  private ClientChatModel clientChatModel;

  public ModelFactory(ClientFactory clientFactory)
  {
    this.clientFactory = clientFactory;
  }

  public ClientChatModel getClientChatModel()
  {
    if(clientChatModel == null)
    {
      clientChatModel = new ClientChatModelManager(clientFactory.getClient());
    }
    return clientChatModel;
  }
}
