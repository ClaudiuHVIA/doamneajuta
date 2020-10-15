package SoccerMatch;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class OldBoysFans implements PropertyChangeListener
{
  @Override public void propertyChange(PropertyChangeEvent evt)
  {
    if("Old Boys scored".equals(evt.getPropertyName()))
    {
      System.out.println("Old Boys Fans: YEEEAAH!");
      System.out.println("Dream Team Fans: buuhuuu");
      System.out.println();
    }
  }
}
