package WS1.Nimbus1;

import WS1.Observables.AlarmClock;
import WS1.Observables.Sensor;

import java.util.Random;

public class Nimbus1TemperatureSensor extends Sensor {
    Random rnd;

    public Nimbus1TemperatureSensor(String type, int interval, AlarmClock alarmClock) {
        super(type, interval, alarmClock);
        System.out.println("Nimbus1TemperatureSensor was created");
        rnd = RandomSupplier.getRnd();
    }

    @Override
    public int read() {
        // use the RandomSupplier to generate a random value between 0 and 40
        return rnd.nextInt(41);
    }
}
