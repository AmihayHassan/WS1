package WS1.Observers;

import WS1.Observables.Trend;

public class LogPressTrendObserver implements Observer {
    private final Log log;

    public LogPressTrendObserver(Log log) {
        this.log = log;
    }

    @Override
    public void update(int value) {
        log.DisplayTrend(Trend.values()[value]);
    }

}
