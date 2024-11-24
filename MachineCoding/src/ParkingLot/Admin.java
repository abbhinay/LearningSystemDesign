package ParkingLot;

import ParkingLot.Gates.ParkingRate;

public class Admin {
    ParkingLot parkingLot = ParkingLot.getInstance();
    ParkingRate parkingRate = ParkingRate.getInstance();

    public void initializeParkingLot() {
        parkingLot.addLevel(new Level(1, 100));
        parkingLot.addLevel(new Level(2, 80));
        parkingLot.addEntrance("entrance1");
        parkingLot.addEntrance("entrance2");
        parkingLot.addExit("exit1");
        parkingLot.addExit("exit2");
        parkingRate.setBaseRate(2.5f);
    }
}
