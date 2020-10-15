package phone;

public class Phone
{
  private PhoneState currentState;
  private int currentVolume;

  public Phone()
  {
    currentState = new VibrateState();
  }

  public void receiveMessage(String txt)
  {
    currentState.onReceiveMessage(txt, this);
  }

  public void receiveCall()
  {
    currentState.onReceiveCall(this);
  }

  public void volumeButtonUp()
  {
    currentState.onVolumeButtonUp(this);
  }

  public void volumeButtonDown()
  {
    currentState.onVolumeButtonDown(this);
  }

  public void goToSilent()
  {
    currentState = new SilentState();
  }

  public void goToVibrate()
  {
    currentState = new VibrateState();
  }

  public void goToSound()
  {
    currentState = new SoundState();
  }

  protected void turnVolumeUp()
  {
      currentVolume++;
  }

  protected void turnVolumeDown()
  {
      currentVolume--;
  }

  protected void playRingTone()
  {
    System.out.println("Ring ring");
  }

  protected void vibrate()
  {
    System.out.println("Bzzz");
  }

  protected void lightUpScreen()
  {
    System.out.println("Screen lighted up");
  }

  protected void beepBeep()
  {
    System.out.println("Beep beep");
  }

  protected int getVolume()
  {
    return currentVolume;
  }

  protected void setState(PhoneState state)
  {
    currentState = state;
  }
}
