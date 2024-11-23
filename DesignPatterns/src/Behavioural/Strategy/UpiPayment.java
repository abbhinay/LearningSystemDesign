package Behavioural.Strategy;

public class UpiPayment implements PaymentStrategy{
    public void pay(int amount) {
        System.out.println("paying through UPI "+amount);
    }
}
