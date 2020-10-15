package HeatingSystem.model;

import HeatingSystem.model.radiator.Radiator;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class TemperatureModelManager implements TemperatureModel
{
  private Radiator radiator;
  private PropertyChangeSupport support;
  private double outsideTemperature;
  private double insideTemperature1;
  private double insideTemperature2;

  public TemperatureModelManager()
  {
    radiator = new Radiator();
    support = new PropertyChangeSupport(this);
    radiator.addPropertyListener("PowerChanged",evt -> onPowerChange(evt));
  }

  @Override public void critical()
  {
    String announcement;
    double temperature = ( insideTemperature1 + insideTemperature2 )/2;
    if(temperature > 20)
    {
      announcement = "Critical High Temperature";
    } else
    if(temperature < 5)
    {
      announcement = "Critical Low Temperature";
    } else
    {
      announcement = "";
    }
    support.firePropertyChange("Critical", null, announcement);
  }

  @Override public void onPowerChange(PropertyChangeEvent evt)
  {
    support.firePropertyChange(evt);
  }

  @Override public void increasePowerState()
  {
      radiator.turnUp();
  }

  @Override public void decreasePowerState()
  {
      radiator.turnDown();
  }

  @Override public void setTemperature(int id, double t)
  {
    if(id == 0)
    {
      outsideTemperature = t;
      support.firePropertyChange("OutsideTemperature", null, t);
    } else
      if(id == 1)
      {
        insideTemperature1 = t;
        support.firePropertyChange("InsideTemperature1", null, t);
      } else
        if(id == 2)
        {
          insideTemperature2 = t;
          support.firePropertyChange("InsideTemperature2", null, t);
        }
    critical();
  }

  @Override public double getOutsideTemperature()
  {
    return outsideTemperature;
  }

  @Override public int getRadiatorPowerState()
  {
    return radiator.getPower();
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
