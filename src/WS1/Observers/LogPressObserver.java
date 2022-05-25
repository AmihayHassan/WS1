package WS1.Observers;

public class LogPressObserver implements Observer {
    private final Log log;

    public LogPressObserver(Log log) {
        this.log = log;
    }

    @Override
    public void update(int value) {
        log.DisplayPressure(value);
    }
}
