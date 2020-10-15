package TrafficLights;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class Bus
{
  public Bus(PropertyChangeSubject subject)
  {
    subject.addPropertyChangeListener("GREEN", this::reactToGreen);
    subject.addPropertyChangeListener("YELLOW", this::reactToYellow);
    subject.addPropertyChangeListener("RED", this::reactToRed);
  }

  public void reactToGreen(PropertyChangeEvent evt)
  {
    System.out.println("Bus drives");
  }

  public void reactToYellow(PropertyChangeEvent evt)
  {
    if("RED".equals(evt.getOldValue()))
    {
      System.out.println("Bus turns on the engine");
    } else if("GREEN".equals(evt.getOldValue()))
    {
      System.out.println("Bus slows down");
    }
  }

  public void reactToRed(PropertyChangeEvent evt)
  {
    System.out.println("Bus stops");
  }
}
