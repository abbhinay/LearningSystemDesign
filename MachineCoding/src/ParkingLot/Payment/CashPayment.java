package ParkingLot.Payment;

public class CashPayment implements Payment{
    public void pay(long amount) {
        System.out.println("Payed Rs "+amount+" through cash");
    }
}
