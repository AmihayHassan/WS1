package WS1.Observables;

abstract public class Sensor {
    public Sensor(String type, int interval) {
        this.interval = interval;
        this.type = type;
    }

    int lastReading;
    int interval;
    String type;

    abstract protected int read();

    public void check() {}
}
