package WS1.Observables;

public class AlarmClockRecord {
    int interval;
    int remainingTime;
    AlarmListener listener;

    public AlarmClockRecord(int interval, AlarmListener listener) {
        this.remainingTime = this.interval = interval;
        this.listener = listener;
    }

    public int getRemainingTime() {
        return remainingTime;
    }

    public AlarmListener getListener() {
        return listener;
    }

    public int getInterval() {
        return interval;
    }

    public void setRemainingTime(int remainingTime) {
        this.remainingTime = remainingTime;
    }
}
