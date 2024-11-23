package ParkingLot;

import ParkingLot.Payment.Payment;
import ParkingLot.vehicleType.Vehicle;

import java.util.Date;
import java.util.UUID;

public class ParkingTicket {
    private String ticketNo;
    private Date entryTime;
    private Date exitTime;
    private boolean isActive;
    private Vehicle vehicle;
    private Payment paymentMethod;
    public ParkingTicket(Vehicle vehicle) {
        this.ticketNo = String.valueOf(UUID.randomUUID());
        this.entryTime = new Date();
        this.exitTime = null;
        this.isActive = true;
        this.vehicle = vehicle;
        this.paymentMethod = null;
    }

    public Date getEntryTime() {
        return this.entryTime;
    }

    public Date getExitTime() {
        return this.exitTime;
    }

    public Vehicle getVehicle() {
        return this.vehicle;
    }

    public String getTicketNo() {
        return this.ticketNo;
    }

    public void setStatus(boolean status) {
        this.isActive = status;
    }

    public void setExitDetails() {
        this.exitTime = new Date();
    }

    public void setPaymentMethod(Payment paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public void pay(long amount) {
        this.paymentMethod.pay(amount);
    }

}
