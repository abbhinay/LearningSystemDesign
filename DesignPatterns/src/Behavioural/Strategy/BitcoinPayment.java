package Behavioural.Strategy;

public class BitcoinPayment implements PaymentStrategy{
    public void pay(int amount) {
        System.out.println("paying through bitcoin "+amount);
    }
}
