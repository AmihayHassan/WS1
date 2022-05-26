package WS1.Observers;

import WS1.Observables.PressureTrendSensor.Trend;

public class LogPressTrendObserver implements Observer {
    private final Log log;

    public LogPressTrendObserver(Log log) {
        System.out.println("LogPressTrendObserver was created");
        this.log = log;
    }

    @Override
    public void update(int value) {
        log.DisplayTrend(Trend.values()[value]);
    }

}
