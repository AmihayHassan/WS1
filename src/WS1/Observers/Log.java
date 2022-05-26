package WS1.Observers;

import WS1.Observables.PressureTrendSensor.Trend;
import WS1.Observables.WeatherMonitoringSystem;

public class Log {
    public Log(WeatherMonitoringSystem ws) {
        System.out.println("Log was created");
        ws.addPressureObserver(new LogPressObserver(this));
        ws.addPressureTrendObserver(new LogPressTrendObserver(this));
    }

    public void DisplayTrend(Trend trend) {
        System.out.println("Log: pressure trend = " + trend.name());
    }

    public void DisplayPressure(int pressure) {
        System.out.println("Log: pressure = " + pressure + " millibars");
    }

}
