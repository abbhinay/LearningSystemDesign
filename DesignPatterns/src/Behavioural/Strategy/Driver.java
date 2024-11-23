package Behavioural.Strategy;

public class Driver {
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart(new UpiPayment());
        cart.checkout(100);

        cart.setPaymemtStrategy(new CreditCardPayment());
        cart.checkout(200);

        cart.setPaymemtStrategy(new BitcoinPayment());
        cart.checkout(300);
    }
}
