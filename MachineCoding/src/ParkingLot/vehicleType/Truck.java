package ParkingLot.vehicleType;

public class Truck implements Vehicle{
    String licensePlate;
    VehicleType type;
    public Truck(String licensePlate) {
        this.licensePlate = licensePlate;
        this.type = VehicleType.TRUCK;
    }

    @Override
    public VehicleType getType() {
        return type;
    }
}
