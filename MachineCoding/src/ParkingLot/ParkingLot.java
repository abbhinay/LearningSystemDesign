package ParkingLot;

import ParkingLot.Gates.Entrance;
import ParkingLot.Gates.Exit;
import ParkingLot.Gates.ParkingTicket;
import ParkingLot.vehicleType.Vehicle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ParkingLot {
    private static volatile ParkingLot instance;
    private final List<Level> levels;
    private final HashMap<String, Entrance> entrances;
    private final HashMap<String, Exit> exits;

    private ParkingLot() {
        this.levels = new ArrayList<>();
        this.entrances = new HashMap<>();
        this.exits = new HashMap<>();
    }

    public static ParkingLot getInstance() {
        if(instance==null) {
            synchronized (ParkingLot.class) {
                if(instance==null) {
                    instance = new ParkingLot();
                }
            }
        }
        return instance;
    }

    public void addLevel(Level level) {
        levels.add(level);
    }

    public void addEntrance(String name) {
        this.entrances.put(name, new Entrance(name));
    }

    public void removeEntrance(String name) {
        this.entrances.remove(name);
    }

    public Entrance getEntrance(String name) {
        return this.entrances.get(name);
    }

    public void addExit(String name) {
        this.exits.put(name, new Exit(name));
    }

    public void removeExit(String name) {
        this.exits.remove(name);
    }

    public Exit getExit(String name) {
        return this.exits.get(name);
    }

    public synchronized boolean parkVehicle(Vehicle vehicle) {
        for(Level level : levels) {
            if(level.parkVehicle(vehicle)) {
                System.out.println(vehicle.getType()+" is parked successfully");
                return true;
            }
        }
        System.out.println(vehicle.getType()+" could not be parked");
        return false;
    }

    public synchronized boolean unparkVehicle(ParkingTicket parkingTicket) {
        for(Level level : levels) {
            if(level.unparkVehicle(parkingTicket.getVehicle())) {
                System.out.println(parkingTicket.getVehicle().getType() + " is unparked successfully");
                return true;
            }
        }
        System.out.println(parkingTicket.getVehicle().getType() + " could not be unparked");
        return false;
    }

    public void displayAvailability() {
        for(Level level : levels) {
            level.displayAvailability();
        }
    }
}
