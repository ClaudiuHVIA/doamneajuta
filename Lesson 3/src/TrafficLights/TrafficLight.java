package TrafficLights;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.List;

public class TrafficLight implements PropertyChangeSubject{

    private String[] lights = {"GREEN", "YELLOW", "RED", "YELLOW"};
    private int count = 1;
    private String currentLight;
    private String previousLight;
    //private ArrayList<Car> cars;

    private PropertyChangeSupport support;

    public TrafficLight()
    {
        currentLight = lights[count];
        support = new PropertyChangeSupport(this);
    }
/*
    public TrafficLight(ArrayList<Car> cars) {
        currentLight = lights[count];
        this.cars = cars;
    }

 */

    public void start() throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            Thread.sleep(1000);
            count = (++count) % 4;
            previousLight = currentLight;
            currentLight = lights[count];
            System.out.println("\nLight is " + currentLight);
            /*

            for(Car car : cars)
            {
                car.lightChanged(currentLight);
            }

             */

            support.firePropertyChange("LightChanged", previousLight, currentLight);
            support.firePropertyChange(currentLight, previousLight, currentLight);
        }

    }

    @Override public void addPropertyChangeListener(String eventName,
        PropertyChangeListener listener)
    {
        if(eventName == null || "".equals(eventName))
        {
            addPropertyChangeListener(listener);
        }
        else
        {
            support.addPropertyChangeListener(eventName, listener);
        }
    }

    @Override public void addPropertyChangeListener(
        PropertyChangeListener listener)
    {
        support.addPropertyChangeListener(listener);
    }

    @Override public void removePropertyChangeListener(String eventName,
        PropertyChangeListener listener)
    {
        if(eventName == null || "".equals(eventName))
        {
            removePropertyChangeListener(listener);
        }
        else
        {
            support.removePropertyChangeListener(eventName, listener);
        }
    }

    @Override public void removePropertyChangeListener(
        PropertyChangeListener listener)
    {
        removePropertyChangeListener(listener);
    }
}
