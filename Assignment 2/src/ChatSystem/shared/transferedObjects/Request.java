package ChatSystem.shared.transferedObjects;

import java.io.Serializable;

public class Request implements Serializable
{
  private RequestType type;
  private Object argument;

  public Request(RequestType type, Object argument)
  {
    this.type = type;
    this.argument = argument;
  }

  public RequestType getType()
  {
    return type;
  }

  public Object getArgument()
  {
    return argument;
  }
}
