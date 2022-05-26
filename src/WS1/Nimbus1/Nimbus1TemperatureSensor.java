package WS1.Nimbus1;

import WS1.Observables.AlarmClock;
import WS1.Observables.Sensor;

import java.util.Random;

public class Nimbus1TemperatureSensor extends Sensor {
    Random rnd;

    public Nimbus1TemperatureSensor(String type, int interval, AlarmClock alarmClock) {
        super(type, interval, alarmClock);
        rnd = RandomSupplier.getRnd();
    }

    @Override
    public int read() {
        return rnd.nextInt(40);
    }
}
