package WS1.Observables;

abstract public class Sensor extends Observable {
    int lastReading;
    int interval;
    String type;

    public Sensor(String type, int interval, AlarmClock ac) {
        this.interval = interval;
        this.type = type;
        ac.register(interval, new SensorAlarmListener(this));
        System.out.println(type + " registered to clock");
    }


    abstract protected int read();

    public void check() {
        int reading = read();
        if (reading != lastReading) {
            lastReading = reading;
            notifyObservers(reading);
        }
    }
}
