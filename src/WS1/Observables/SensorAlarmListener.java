package WS1.Observables;

public class SensorAlarmListener implements AlarmListener {
    private Sensor sensor;

    public SensorAlarmListener(Sensor sensor) {
        System.out.println("SensorAlarmListener was created");
        this.sensor = sensor;
    }

    @Override
    public void wakeup() {
        sensor.check();
    }
}
