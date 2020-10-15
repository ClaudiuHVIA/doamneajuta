package phone;

public class StartPhone
{
  public static void main(String[] args)
  {
    Phone phone = new Phone();
    phone.receiveCall();
    phone.receiveMessage("Hello message");
    phone.goToVibrate();
    phone.receiveCall();
    phone.receiveMessage("Hello message2");
    phone.goToSound();
    phone.receiveCall();
    phone.receiveMessage("Hello message3");
  }
}
