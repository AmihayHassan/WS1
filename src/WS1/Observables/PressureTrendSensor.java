package WS1.Observables;

public class PressureTrendSensor extends Sensor{
    int lastReading1;
    int lastReading2;
    int lastReading3;
    Trend PressureState;
    Trend lastState;

    public PressureTrendSensor(String type, int interval) {
        super(type, interval);
    }

    @Override
    protected int read() {
        return calc().ordinal();
    }

    public Trend calc() {
        // check if the readings are increasing or decreasing
        if (lastReading1 < lastReading2 && lastReading2 < lastReading3) {
            return Trend.UP;
        } else if (lastReading1 > lastReading2 && lastReading2 > lastReading3) {
            return Trend.DOWN;
        } else {
            return Trend.STABLE;
        }
    }

    public void check() {

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
