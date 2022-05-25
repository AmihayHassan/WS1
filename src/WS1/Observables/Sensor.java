package WS1.Observables;

abstract public class Sensor extends Observable {

    public Sensor(String type, int interval, AlarmClock ac) {
        this.interval = interval;
        this.type = type;
        ac.register(interval, new SensorAlarmListener(this));
    }

    int lastReading;
    int interval;
    String type;

    abstract protected int read();

    public void check() {
        int reading = read();
        if (reading != lastReading) {
            lastReading = reading;
            notifyObservers(reading);
        }
    }
}
