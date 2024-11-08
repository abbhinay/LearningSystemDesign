import vehicleType.Car;
import vehicleType.Motorcycle;
import vehicleType.Truck;
import vehicleType.Vehicle;

public class ParkingLotController {
    public static void main(String[] args) {
        ParkingLot parkingLot = ParkingLot.getInstance();
        parkingLot.addLevel(new Level(1, 10));
        parkingLot.addLevel(new Level(2, 8));

        Vehicle car = new Car("ABC123");
        Vehicle truck = new Truck("XYZ678");
        Vehicle motorcycle = new Motorcycle("PQR809");

        //Park Vehicle
        parkingLot.parkVehicle(car);
        parkingLot.parkVehicle(truck);
        parkingLot.parkVehicle(motorcycle);

        //Display Availability
        parkingLot.displayAvailability();

        //Unpark Vehicle
        parkingLot.unparkVehicle(car);

        //Display updated Availability
        parkingLot.displayAvailability();

    }
}
