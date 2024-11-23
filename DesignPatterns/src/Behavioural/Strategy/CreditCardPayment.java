package Behavioural.Strategy;

public class CreditCardPayment implements PaymentStrategy{
    public void pay(int amount) {
        System.out.println("paying through credit card "+amount);
    }
}
