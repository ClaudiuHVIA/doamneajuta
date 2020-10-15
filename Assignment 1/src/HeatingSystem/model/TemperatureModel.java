package HeatingSystem.model;

import HeatingSystem.util.PropertyChangeSubject;

import java.beans.PropertyChangeEvent;

public interface TemperatureModel extends PropertyChangeSubject
{
  public void critical();
  public void onPowerChange(PropertyChangeEvent evt);
  public void increasePowerState();
  public void decreasePowerState();
  public void setTemperature(int id, double t);
  public double getOutsideTemperature();
  public int getRadiatorPowerState();
}
