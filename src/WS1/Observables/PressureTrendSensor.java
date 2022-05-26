package WS1.Observables;

import WS1.Nimbus1.Nimbus1PressureSensor;
import WS1.Observers.Observer;


public class PressureTrendSensor extends Observable implements Observer {
    public enum Trend {
        RISING, FALLING, STABLE
    }

    int lastReading1;
    int lastReading2;
    int lastReading3;
    Trend PressureState;
    Trend lastState;

    public PressureTrendSensor(Sensor sensor) {
        lastReading1 = lastReading2 = lastReading3 = 0;
        PressureState = lastState = Trend.STABLE;
//        System.out.println("PressureTrendSensor was created");
        sensor.addObserver(this);
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

    private void check() {
        Trend newState = calc();
        if (newState != lastState) {
            lastState = newState;
            this.notifyObservers(newState.ordinal());
        }
    }

    public void update(int reading) {
        // readings are like queue
        // lastReading1 is the oldest reading
        // lastReading3 is the newest reading
        lastReading1 = lastReading2;
        lastReading2 = lastReading3;
        lastReading3 = reading;
        check();
    }
}
