package DoctorWaitingRoom;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;

public class WaitingRoom implements PropertyChangeSubject, Runnable
{
  private PropertyChangeSupport support;

  public WaitingRoom()
  {
    support = new PropertyChangeSupport(this);
  }

  @Override public void addPropertyChangeListener(String eventName,
      PropertyChangeListener listener)
  {
    support.addPropertyChangeListener(eventName, listener);
  }

  @Override public void addPropertyChangeListener(
      PropertyChangeListener listener)
  {
    support.addPropertyChangeListener(listener);
  }

  @Override public void removePropertyChangeListener(String eventName,
      PropertyChangeListener listener)
  {
    support.removePropertyChangeListener(eventName, listener);
  }

  @Override public void removePropertyChangeListener(
      PropertyChangeListener listener)
  {
    support.removePropertyChangeListener(listener);
  }


  @Override public void run()
  {
    int ticketNumber=0;
    while(true)
    {
      try
      {
        Thread.sleep(100);
        System.out.println("Diing");
        support.firePropertyChange("NextTicket", -1, ticketNumber);
        ticketNumber++;
      }
      catch (InterruptedException e)
      {
        e.printStackTrace();
      }
    }
  }
}
