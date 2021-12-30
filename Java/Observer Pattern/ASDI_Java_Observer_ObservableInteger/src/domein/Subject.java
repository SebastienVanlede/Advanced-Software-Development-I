package domein;

public interface Subject {
    void addObserver(Observer observer);
    void removeObserver(Observer observer);
}
