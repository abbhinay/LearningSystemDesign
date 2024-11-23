package Behavioural.Strategy;

public class Driver {
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart(new UpiPayment("myupiid@okhdfc"));
        cart.checkout(100);

        cart.setPaymemtStrategy(new CreditCardPayment("abhinay", "22500", "233", "21/3/2030"));
        cart.checkout(200);

        cart.setPaymemtStrategy(new BitcoinPayment("23456789"));
        cart.checkout(300);
    }
}
