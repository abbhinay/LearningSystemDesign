package Behavioural.Strategy;

public class BitcoinPayment implements PaymentStrategy{
    private String bitcoinAddress;
    public BitcoinPayment(String bitcoinAddress) {
        this.bitcoinAddress = bitcoinAddress;
    }
    public void pay(int amount) {
        System.out.println("paying through bitcoin "+amount);
    }
}
