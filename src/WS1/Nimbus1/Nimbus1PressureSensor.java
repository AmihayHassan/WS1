package WS1.Nimbus1;

import WS1.Observables.Sensor;

import java.util.Random;

public class Nimbus1PressureSensor extends Sensor {
    Random rnd;

    public Nimbus1PressureSensor(String type, int interval) {
        super(type, interval);
        rnd = RandomSupplier.getRnd();
    }

    @Override
    public int read() {
        // use the RandomSupplier to generate a random value between 950 and 1050
        return rnd.nextInt(101) + 950;
    }
}
