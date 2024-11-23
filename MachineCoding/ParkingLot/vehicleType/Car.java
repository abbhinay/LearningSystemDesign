package vehicleType;

public class Car implements Vehicle{
    String licensePlate;
    VehicleType type;
    public Car(String licensePlate) {
        this.licensePlate = licensePlate;
        this.type = VehicleType.CAR;
    }

    @Override
    public VehicleType getType() {
        return type;
    }
}
