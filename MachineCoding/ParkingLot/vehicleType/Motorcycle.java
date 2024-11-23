package vehicleType;

public class Motorcycle implements Vehicle{
    String licensePlate;
    VehicleType type;
    public Motorcycle(String licensePlate) {
        this.licensePlate = licensePlate;
        this.type = VehicleType.MOTORCYCLE;
    }

    @Override
    public VehicleType getType() {
        return type;
    }
}
