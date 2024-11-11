import vehicleType.Vehicle;

import java.sql.Time;
import java.util.Date;
import java.util.Timer;
import java.util.UUID;

public class ParkingTicket {
    private String ticketNo;
    private Date entryTime;
    private Date exitTime;
    private boolean isActive;
    private Vehicle vehicle;
    public ParkingTicket(Vehicle vehicle) {
        this.ticketNo = UUID.randomUUID().toString();
        this.entryTime = new Date();
        this.exitTime = null;
        this.isActive = true;
        this.vehicle = vehicle;
    }

    public Date getEntryTime() {
        return this.entryTime;
    }

    public Date getExitTime() {
        return this.exitTime;
    }

    public Vehicle getVehicle() {
        return this.vehicle;
    }

    public void setExitDetails() {
        this.exitTime = new Date();
    }
}
