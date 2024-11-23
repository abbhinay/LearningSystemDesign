package ParkingLot.Payment;

public class CreditCardPayment implements Payment{
    String name;
    String cardNumber;
    Integer cvv;
    String expiryDate;

    public CreditCardPayment(String name, String cardNumber, Integer cvv, String expiryDate) {
        this.name = name;
        this.cardNumber = cardNumber;
        this.cvv = cvv;
        this.expiryDate = expiryDate;
    }
    public void pay(long amount) {
        System.out.println("Payed Rs "+amount+" through credit card");
    }
}
