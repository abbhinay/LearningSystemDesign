package Behavioural.Observer;

import java.util.ArrayList;
import java.util.List;

public class WeatherStation implements Observable{
    private List<Observer> list;

    private double temperature;
    public WeatherStation() {
        this.list = new ArrayList<>();
    }

    public boolean registerObserver(Observer observer) {
        return this.list.add(observer);
    }

    public boolean unregisterObserver(Observer observer) {
        return this.list.remove(observer);
    }

    public void notifyObservers() {
        for(Observer observer : list) {
            observer.notify(temperature);
        }
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
        notifyObservers();
    }
}
