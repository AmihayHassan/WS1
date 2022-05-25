package WS1.Observables;

import WS1.Nimbus1.Nimbus1Clock;
import WS1.Nimbus1.Nimbus1PressureSensor;
import WS1.Nimbus1.Nimbus1TemperatureSensor;
import WS1.Observers.Log;
import WS1.Observers.MonitoringScreen;
import WS1.Observers.Observer;

public class WeatherMonitoringSystem {
    private final Sensor itsTemperatureSensor;
    private final Sensor itsPressureSensor;
    private final PressureTrendSensor itsPressureTrendSensor;


    public WeatherMonitoringSystem() {
        System.out.println("WeatherMonitoringSystem was created");
        AlarmClock ac = Nimbus1Clock.theInstance();
        itsPressureSensor = new Nimbus1PressureSensor("millibars", 1100, ac);
        itsTemperatureSensor = new Nimbus1TemperatureSensor("Celcius", 700, ac);
        itsPressureTrendSensor = new PressureTrendSensor(itsPressureSensor);
    }

    public void addTemperatureObserver(Observer o) {
        itsTemperatureSensor.addObserver(o);
    }

    public void addPressureObserver(Observer o) {
        itsPressureSensor.addObserver(o);
    }

    public void addPressureTrendObserver(Observer o) {
        itsPressureTrendSensor.addObserver(o);
    }

    protected static WeatherMonitoringSystem instance = null;

    public static WeatherMonitoringSystem theInstance() {
        if (instance == null) {
            instance = new WeatherMonitoringSystem();
        }
        return instance;
    }
}
