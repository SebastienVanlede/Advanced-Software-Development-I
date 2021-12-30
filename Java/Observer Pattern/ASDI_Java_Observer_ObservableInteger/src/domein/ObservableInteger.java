package domein;

import java.util.HashSet;
import java.util.Set;

public class ObservableInteger implements Subject {

    private int value = 1;
    private Set<Observer> observers = new HashSet<>();

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
        notifyObservers();
    }

    public void add(int number) {
        setValue(value + number);
    }

    public void subtract(int number) {
        setValue(value - number);
    }

    public int getDoubleValue() {
        return value * 2;
    }

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
        observer.update(value);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);

    }

    private void notifyObservers() {
        observers.forEach(obs -> obs.update(value));
    }
}
