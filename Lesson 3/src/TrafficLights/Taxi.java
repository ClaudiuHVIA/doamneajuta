package TrafficLights;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class Taxi
{
  public Taxi(PropertyChangeSubject subject)
  {
    PropertyChangeListener listener = new PropertyChangeListener()
    {
      @Override public void propertyChange(PropertyChangeEvent evt)
      {
        reactToChange(evt);
      }
    };
    subject.addPropertyChangeListener(listener);
  }


  public void reactToChange(PropertyChangeEvent evt)
  {
    String oldValue = (String) evt.getOldValue();
    String newValue = (String) evt.getNewValue();

    if("GREEN".equals(newValue)) {
      System.out.println("Taxi drives");
    }
    else
    if("YELLOW".equals(newValue))
    {
      if("RED".equals(oldValue))
      {
        System.out.println("Taxi turns engine on");
      }
      else
      {
        System.out.println("Taxi slows down");
      }
    }
    else
    if("RED".equals(newValue))
    {
      System.out.println("Taxi stops");
    }
  }
}
