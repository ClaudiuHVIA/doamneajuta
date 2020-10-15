package HeatingSystem.model.radiator;

import HeatingSystem.util.PropertyChangeSubject;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class Radiator implements PropertyChangeSubject
{
  private RadiatorState currentState;
  private PropertyChangeSupport support = new PropertyChangeSupport(this);

  public Radiator()
  {
    currentState = new OffState();
  }

  public void turnUp()
  {
    currentState.turnUp(this);
  }

  public void turnDown()
  {
    currentState.turnDown(this);
  }

  public int getPower()
  {
    return currentState.getPower();
  }

  protected void setPowerState(RadiatorState state)
  {
    currentState = state;
    support.firePropertyChange("PowerChanged", null, getPower());
  }

  public String toString()
  {
    return "power: "+currentState.getPower();
  }

  @Override public void addPropertyListener(PropertyChangeListener listener)
  {
    support.addPropertyChangeListener(listener);
  }

  @Override public void addPropertyListener(String eventName,
      PropertyChangeListener listener)
  {
    if(eventName == null)
    {
      support.addPropertyChangeListener(listener);
    } else {
      support.addPropertyChangeListener(eventName, listener);
    }
  }

  @Override public void removePropertyListener(PropertyChangeListener listener)
  {
    support.removePropertyChangeListener(listener);
  }

  @Override public void removePropertyListener(String eventName,
      PropertyChangeListener listener)
  {
    if(eventName == null)
    {
      support.removePropertyChangeListener(listener);
    } else {
      support.addPropertyChangeListener(eventName, listener);
    }
  }
}
