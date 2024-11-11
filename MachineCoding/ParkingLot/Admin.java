public class Admin {
    ParkingLot parkingLot = ParkingLot.getInstance();

    public void initializeParkingLot() {
        parkingLot.addLevel(new Level(1, 100));
        parkingLot.addLevel(new Level(2, 80));
    }
}
