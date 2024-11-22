package Behavioural.Observer;

public interface Observable {
    public boolean registerObserver(Observer observer);
    public boolean unregisterObserver(Observer observer);
    public void notifyObservers();
}
