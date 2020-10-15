package SoccerMatch;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class Referee implements PropertyChangeListener
{
  @Override public void propertyChange(PropertyChangeEvent evt)
  {
    if("Dream Team made a rough tackle".equals(evt.getPropertyName()))
    {
      System.out.println("Referee gives Dream Team a yellow card for a rough tackle");
    }

    if("Old Boys made a rough tackle".equals(evt.getPropertyName()))
    {
      System.out.println("Referee gives Old Boys a yellow card for a rough tackle");
    }
  }
}
