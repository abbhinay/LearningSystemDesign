package ParkingLot.Gates;

import ParkingLot.Payment.Payment;

public class Exit {
    private String name;

    public Exit(String name) {
        this.name = name;
    }

    public void validateTicket(ParkingTicket parkingTicket) {
        handlePayment(parkingTicket);
    }

    public void setPaymentMethod(ParkingTicket parkingTicket, Payment payment) {
        parkingTicket.setPaymentMethod(payment);
    }

    public synchronized void handlePayment(ParkingTicket parkingTicket) {
        parkingTicket.setExitDetails();
        long time = parkingTicket.getExitTime().getMinutes()-parkingTicket.getEntryTime().getMinutes();
        long amount = ParkingRate.getInstance().getPayingAmount(time, parkingTicket.getVehicle().getType());
        System.out.println("handling payment "+parkingTicket.getEntryTime()+" "+parkingTicket.getExitTime()+
                "\nplease pay "+amount+"Rs");
        parkingTicket.pay(amount);
        parkingTicket.setStatus(false);
    }
}
