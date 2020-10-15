package ChatSystem.shared;

import java.io.Serializable;

public class Message implements Serializable
{
  private String messageBody;
  private String user;

  public Message(String user, String messageBody)
  {
    this.user = user;
    this.messageBody = messageBody;
  }

  public String getMessageBody()
  {
    return messageBody;
  }

  public String getUser()
  {
    return user;
  }

  public String toString()
  {
    return user + ": " + messageBody;
  }

}
