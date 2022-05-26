package WS1.Observers;

public class MSTempObserver implements Observer {
    private final MonitoringScreen ms;

    public MSTempObserver(MonitoringScreen ms) {
        System.out.println("MSTempObserver was created");
        this.ms = ms;
    }

    @Override
    public void update(int value) {
        ms.DisplayTemp(value);
    }
}
