package domein;

import gui.ObservableIntegerFrameController;

public class DomeinController {

    private ObservableInteger observableInteger = new ObservableInteger();

    public void up() {
        observableInteger.add(1);
    }

    public void down() {
        observableInteger.subtract(1);
    }

    public int getDoubleValue() {
        return observableInteger.getDoubleValue();
    }

    public void addObserver(Observer observer){
        observableInteger.addObserver(observer);
    }
}
