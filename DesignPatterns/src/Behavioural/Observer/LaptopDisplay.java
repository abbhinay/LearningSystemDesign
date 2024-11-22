package Behavioural.Observer;

public class LaptopDisplay implements Observer{
    public void notify(double temperature) {
        System.out.println("current Temperature on Laptop display : "+temperature);
    }
}
