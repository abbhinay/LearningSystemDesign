import vehicleType.Vehicle;

import java.util.Date;
import java.util.UUID;

public class ParkingTicket {
    private String ticketNo;
    private Date entryTime;
    private Date exitTime;
    private boolean isActive;
    private Vehicle vehicle;
    public ParkingTicket(Vehicle vehicle) {
        this.ticketNo = String.valueOf(UUID.randomUUID());
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

    public String getTicketNo() {
        return this.ticketNo;
    }

    public void setStatus(boolean status) {
        this.isActive = status;
    }

    public void setExitDetails() {
        this.exitTime = new Date();
    }

}
