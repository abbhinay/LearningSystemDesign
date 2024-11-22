package Behavioural.Observer;

public class Driver {
    public static void main(String[] args) {
        WeatherStation station = new WeatherStation();

        Observer p1 = new PhoneDisplay();
        Observer p2 = new PhoneDisplay();

        Observer l1 = new LaptopDisplay();
        Observer l2 = new LaptopDisplay();

        station.registerObserver(p1);
        station.registerObserver(p2);
        station.registerObserver(l1);
        station.registerObserver(l2);

        station.setTemperature(34.5);

        station.unregisterObserver(p2);

        station.setTemperature(55.6);

    }
}
