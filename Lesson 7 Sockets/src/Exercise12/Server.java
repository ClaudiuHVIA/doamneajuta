package Exercise12;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Struct;

public class Server
{
  public static void main(String[] args)
      throws IOException, ClassNotFoundException
  {
    ServerSocket serverSocket = new ServerSocket(10000);
    System.out.println("Server started");

    Socket client = serverSocket.accept();
    System.out.println("Client connected");

    ObjectInputStream inFromClient = new ObjectInputStream(client.getInputStream());
    ObjectOutputStream outToClient = new ObjectOutputStream(client.getOutputStream());
    String clientChoose;

    while (true)
    {
      outToClient.writeUnshared("For reversing a string write 'String' or for "
          + "checking a prime write 'Prime' or for closing write 'Close'");

       clientChoose = (String) inFromClient.readObject();
      if(clientChoose.equals("String"))
      {
        outToClient.writeUnshared("Write your string to be converted");
        String givenString = inFromClient.readObject().toString();
        outToClient.writeUnshared(reverseString(givenString));
      } else if(clientChoose.equals("Prime"))
      {
        outToClient.writeUnshared("Write your number to be checked");
        int givenNumber =  Integer.parseInt(inFromClient.readObject().toString());
        outToClient.writeUnshared(checkPrime(givenNumber));
      } else if(clientChoose.equals("Close"))
      {
        outToClient.writeUnshared("Thank you! Good bye!");
        client.close();
        break;
      }
    }


  }

  private static String reverseString(String givenString)
  {
    String reverse = "";
    for(int i = givenString.length()-1;i>=0;i--)
    {
      reverse += givenString.charAt(i);
    }
    return reverse;
  }

  private static boolean checkPrime(int givenNumber)
  {
    if(givenNumber == 1)
    {
      return false;
    }
    for(int i=2;i<=Math.sqrt(givenNumber);i++)
    {
      if(givenNumber % i == 0)
      {
        return false;
      }
    }
    return true;
  }

}
