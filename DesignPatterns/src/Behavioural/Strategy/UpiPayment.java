package Behavioural.Strategy;

public class UpiPayment implements PaymentStrategy{
    private String upiId;
    public UpiPayment(String upiId) {
        this.upiId = upiId;
    }
    public void pay(int amount) {
        System.out.println("paying through UPI "+amount);
    }
}
