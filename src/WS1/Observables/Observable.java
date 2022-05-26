package WS1.Observables;

import WS1.Observers.Observer;

import java.util.Vector;

public class Observable {
    private Vector<Observer> observers = null;
    private boolean changed = false;

    public void addObserver(Observer o) {
        if (observers == null) {
            observers = new Vector<>();
        }
        if (o == null) {
            throw new NullPointerException();
        }
        if (!(observers.contains(o))) {
            observers.addElement(o);
            String suffix = this.getClass().getSimpleName();
            suffix = suffix.replace("Nimbus1", "").replace("Sensor", "");
            // replace the first capital letter with a lower case letter
            suffix = suffix.substring(0, 1).toLowerCase() + suffix.substring(1);
            System.out.println(o.getClass().getSimpleName() + " observes " + suffix);
        }
    }

    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    public void removeObservers() {
        for (Observer o : observers) {
            observers.remove(o);
        }
    }


    public void notifyObservers(int data) {
//        Observer[] arrLocal;
//        synchronized (this) {
//            if (!hasChanged()) {
//                return;
//            }
//            // enter all observers into arrLocal
//            arrLocal = new Observer[observers.size()];
//            observers.copyInto(arrLocal);
//            clearChanged();
//        }
//
//        for (Observer o : arrLocal) {
//            o.update(data);
//        }
        for(Observer o : observers) {
            o.update(data);
        }
    }

    protected synchronized void setChanged() {
        changed = true;
    }

    protected synchronized void clearChanged() {
        changed = false;
    }

    public synchronized boolean hasChanged() {
        return changed;
    }

    public synchronized int countObservers() {
        return observers.size();
    }
}
