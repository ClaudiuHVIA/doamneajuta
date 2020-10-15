package SoccerMatch;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class DreamTeamFans implements PropertyChangeListener
{

  @Override public void propertyChange(PropertyChangeEvent evt)
  {
    if("Dream Team scored".equals(evt.getPropertyName()))
    {
      System.out.println("Dream Team Fans: YEEEAAH!");
      System.out.println("Old Boys Fans: buuhuuu");
      System.out.println();
    }
  }
}
