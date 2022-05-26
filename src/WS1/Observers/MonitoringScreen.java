package WS1.Observers;

import WS1.Observables.WeatherMonitoringSystem;

public class MonitoringScreen {

    public MonitoringScreen(WeatherMonitoringSystem ws) {
        System.out.println("MonitoringScreen was created");
        ws.addTemperatureObserver(new MSTempObserver(this));
        ws.addPressureObserver(new MSPressObserver(this));
    }

    public void DisplayTemp(int temp) {
        System.out.println("MonitoringScreen: temperature = " + temp + " Celsius");
    }

    public void DisplayPressure(int pressure) {
        System.out.println("MonitoringScreen: pressure = " + pressure + " millibars");
    }
}
