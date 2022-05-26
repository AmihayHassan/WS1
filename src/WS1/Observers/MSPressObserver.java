package WS1.Observers;

public class MSPressObserver implements Observer {
    private final MonitoringScreen ms;

    public MSPressObserver(MonitoringScreen ms) {
        System.out.println("MSPressObserver was created");
        this.ms = ms;
    }

    @Override
    public void update(int value) {
        ms.DisplayPressure(value);
    }
}
