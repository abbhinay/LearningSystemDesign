package ParkingLot.Gates;

import ParkingLot.vehicleType.Vehicle;

public class Entrance {
    private String name;

    public Entrance(String name) {
        this.name = name;
    }

    public ParkingTicket getTicket(Vehicle vehicle) {
        return new ParkingTicket(vehicle);
    }
}
