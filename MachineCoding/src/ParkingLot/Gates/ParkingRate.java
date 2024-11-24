package ParkingLot.Gates;

import ParkingLot.vehicleType.VehicleType;

public class ParkingRate {
    private static volatile ParkingRate instance;
    private float baseRate;

    private ParkingRate() {}

    public static ParkingRate getInstance() {
        if(instance==null) {
            synchronized (ParkingRate.class) {
                if(instance==null) {
                    instance = new ParkingRate();
                }
            }
        }
        return instance;
    }

    public void setBaseRate(float baseRate) {
        this.baseRate = baseRate;
    }

    public long getPayingAmount(long time, VehicleType vehicleType) {
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
}
