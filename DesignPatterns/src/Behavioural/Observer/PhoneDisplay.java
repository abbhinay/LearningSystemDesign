package Behavioural.Observer;

public class PhoneDisplay implements Observer{
    public void notify(double temperature) {
        System.out.println("current Temperature on phone display : "+temperature);
    }
}
