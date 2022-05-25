package WS1.Observables;

import WS1.Nimbus1.Nimbus1PressureSensor;
import WS1.Observers.Observer;

public class PressureTrendSensor extends Observable implements Observer {
    int lastReading1;
    int lastReading2;
    int lastReading3;
    Trend PressureState;
    Trend lastState;

    public PressureTrendSensor(Sensor sensor) {
        sensor.addObserver(this);
        System.out.println("PressureTrendSensor was created");
    }

    public Trend calc() {
        // check if the readings are increasing or decreasing
        if (lastReading1 < lastReading2 && lastReading2 < lastReading3) {
            return Trend.RISING;
        } else if (lastReading1 > lastReading2 && lastReading2 > lastReading3) {
            return Trend.FALLING;
        } else {
            return Trend.STABLE;
        }
    }

    public void update(int reading) {
        // readings are like queue
        // lastReading1 is the oldest reading
        // lastReading3 is the newest reading
        lastReading2 = lastReading3;
        lastReading1 = lastReading2;
        lastReading3 = reading;
    }
}
