package ParkingLot;

import ParkingLot.Payment.Payment;
import ParkingLot.vehicleType.Vehicle;
import ParkingLot.vehicleType.VehicleType;

import java.util.ArrayList;
import java.util.List;

public class ParkingLot {
    private static volatile ParkingLot instance;
    private final List<Level> levels;
    private float baseRate;

    private ParkingLot() {
        this.levels = new ArrayList<>();
    }

    public static ParkingLot getInstance() {
        if(instance==null) {
            synchronized (ParkingLot.class) {
                if(instance==null) {
                    instance = new ParkingLot();
                }
            }
        }
        return instance;
    }

    public void addLevel(Level level) {
        levels.add(level);
    }

    public void addParkingRate(float rate) {
        this.baseRate = rate;
    }

    public void setPaymentMethod(ParkingTicket parkingTicket, Payment payment) {
        parkingTicket.setPaymentMethod(payment);
    }

    public synchronized ParkingTicket parkVehicle(Vehicle vehicle) {
        for(Level level : levels) {
            if(level.parkVehicle(vehicle)) {
                System.out.println(vehicle.getType()+" is parked successfully");
                return new ParkingTicket(vehicle);
            }
        }
        System.out.println(vehicle.getType()+" could not be parked");
        return null;
    }

    public synchronized boolean unparkVehicle(ParkingTicket parkingTicket) {
        for(Level level : levels) {
            if(level.unparkVehicle(parkingTicket.getVehicle())) {
                System.out.println(parkingTicket.getVehicle().getType() + " is unparked successfully");
                return true;
            }
        }
        System.out.println(parkingTicket.getVehicle().getType() + " could not be unparked");
        return false;
    }

    public synchronized void handlePayment(ParkingTicket parkingTicket) {
        parkingTicket.setExitDetails();
        long time = parkingTicket.getExitTime().getMinutes()-parkingTicket.getEntryTime().getMinutes();
        long amount = getPayingAmount(time, parkingTicket.getVehicle().getType());
        System.out.println("handling payment "+parkingTicket.getEntryTime()+" "+parkingTicket.getExitTime()+
                "\nplease pay "+amount+"Rs");
        parkingTicket.pay(amount);
        parkingTicket.setStatus(false);
    }

    private long getPayingAmount(long time, VehicleType vehicleType) {
        switch(vehicleType) {
            case CAR :
                return (long)(1.5*time*baseRate);
            case MOTORCYCLE:
                return (long)(time*baseRate);
            case TRUCK:
                return (long)(2*time*baseRate);
        }
        return 0;
    }

    public void displayAvailability() {
        for(Level level : levels) {
            level.displayAvailability();
        }
    }
}
