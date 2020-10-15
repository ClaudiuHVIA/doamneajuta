package TrafficLights;

import java.util.ArrayList;

public class Start
{
  public static void main(String[] args) throws InterruptedException
  {
    /*
    Car car1 = new Car(1);
    Car car2 = new Car(2);
    Car car3 = new Car(3);
    Car car4 = new Car(4);
    ArrayList<Car> cars = new ArrayList<Car>();
    cars.add(car1);
    cars.add(car2);
    cars.add(car3);
    cars.add(car4);
    TrafficLight trafficLight = new TrafficLight(cars);
    trafficLight.start();
     */

    TrafficLight trafficLight = new TrafficLight();
    Car car1 = new Car(1);
    Car car2 = new Car(2);
    Taxi taxi = new Taxi(trafficLight);
    Bus bus = new Bus(trafficLight);
    trafficLight.addPropertyChangeListener(car1);
    trafficLight.addPropertyChangeListener(car2);
    trafficLight.start();
  }
}
