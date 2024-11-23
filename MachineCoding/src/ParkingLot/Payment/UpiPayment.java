package ParkingLot.Payment;

public class UpiPayment implements Payment{
    String upiId;

    public UpiPayment(String upiId) {
        this.upiId = upiId;
    }
    public void pay(long amount) {
        System.out.println("Payed Rs "+amount+" through upi");
    }
}
