package TrafficLights;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class Car implements PropertyChangeListener
{

        private int id;
		//private String previousLight;
		
        public Car(int id) {
            this.id = id;
        }
/*
        public void lightChanged(String light) {

            if("GREEN".equals(light)) {
                System.out.println("Car " + id + " drives");
            } else if("YELLOW".equals(light)) {
                if("RED".equals(previousLight)) {
                    System.out.println("Car " + id + " turns engine on");
                } else {
                    System.out.println("Car " + id + " slows down");
                }
            } else if("RED".equals(light)) {
                System.out.println("Car " + id + " stops");
            }
			previousLight = light;
        }
*/
    @Override public void propertyChange(PropertyChangeEvent evt)
    {
        String oldValue = (String) evt.getOldValue();
        String newValue = (String) evt.getNewValue();

        if("GREEN".equals(newValue)) {
            System.out.println("Car " + id + " drives");
        }
        else
            if("YELLOW".equals(newValue))
            {
            if("RED".equals(oldValue))
            {
                System.out.println("Car " + id + " turns engine on");
            }
            else
                {
                    System.out.println("Car " + id + " slows down");
                }
            }
            else
                if("RED".equals(newValue))
                {
                    System.out.println("Car " + id + " stops");
                }
    }
}

