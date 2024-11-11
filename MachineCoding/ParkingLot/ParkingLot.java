import vehicleType.Vehicle;

import java.util.ArrayList;
import java.util.List;

public class ParkingLot {
    private static ParkingLot instance;
    private final List<Level> levels;

    private ParkingLot() {
        this.levels = new ArrayList<>();
    }

    public static synchronized ParkingLot getInstance() {
        if(instance==null) instance = new ParkingLot();
        return instance;
    }

    public void addLevel(Level level) {
        levels.add(level);
    }

    public ParkingTicket parkVehicle(Vehicle vehicle) {
        for(Level level : levels) {
            if(level.parkVehicle(vehicle)) {
                System.out.println(vehicle.getType()+" is parked successfully");
                return new ParkingTicket(vehicle);
            }
        }
        System.out.println(vehicle.getType()+" could not be parked");
        return null;
    }

    public boolean unparkVehicle(ParkingTicket parkingTicket) {
        for(Level level : levels) {
            if(level.unparkVehicle(parkingTicket.getVehicle())) {
                handlePayment(parkingTicket);
                System.out.println(parkingTicket.getVehicle().getType() + " is unparked successfully");
                return true;
            }
        }
        System.out.println(parkingTicket.getVehicle().getType() + " could not be unparked");
        return false;
    }

    private void handlePayment(ParkingTicket parkingTicket) {
        parkingTicket.setExitDetails();

        System.out.println("handling payment"+parkingTicket.getEntryTime()+" "+parkingTicket.getExitTime());
    }

    public void displayAvailability() {
        for(Level level : levels) {
            level.displayAvailability();
        }
    }
}
