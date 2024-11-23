package ParkingLot;

import ParkingLot.vehicleType.Vehicle;
import ParkingLot.vehicleType.VehicleType;

import java.util.ArrayList;
import java.util.List;

public class Level {
    private final int floor;
    private final List<ParkingSpot> parkingSpots;

    public Level(int floor, int numberOfSpots) {
        this.floor = floor;
        this.parkingSpots = new ArrayList<>(numberOfSpots);

        // Assign spots in ratio of 50:40:10 for bikes, cars, trucks
        int index = 0;
        while(index<(numberOfSpots*0.5)) {
            parkingSpots.add(new ParkingSpot(index, VehicleType.MOTORCYCLE));
            index++;
        }
        while(index<(numberOfSpots*0.9)) {
            parkingSpots.add(new ParkingSpot(index, VehicleType.CAR));
            index++;
        }
        while(index<numberOfSpots) {
            parkingSpots.add(new ParkingSpot(index, VehicleType.TRUCK));
            index++;
        }
    }

    public synchronized boolean parkVehicle(Vehicle vehicle) {
        for(ParkingSpot parkingSpot : parkingSpots) {
            if(parkingSpot.isAvailable() && parkingSpot.getVehicleType()==vehicle.getType()) {
                parkingSpot.parkVehicle(vehicle);
                return true;
            }
        }
        return false;
    }

    public synchronized boolean unparkVehicle(Vehicle vehicle) {
        for(ParkingSpot parkingSpot : parkingSpots) {
            if(!parkingSpot.isAvailable() && parkingSpot.getVehicleType()==vehicle.getType() && parkingSpot.getParkedVehicle().equals(vehicle)) {
                parkingSpot.unparkVehicle();
                return true;
            }
        }
        return false;
    }

    public void displayAvailability() {
        System.out.println("ParkingLot.Level " + floor + " Availability: ");
        for(ParkingSpot parkingSpot : parkingSpots) {
            System.out.println("Parking Spot " + parkingSpot.getSpotNumber() + " : " + (parkingSpot.isAvailable() ? "Available for " : "Occupied by ") + parkingSpot.getVehicleType());
        }
    }
}
