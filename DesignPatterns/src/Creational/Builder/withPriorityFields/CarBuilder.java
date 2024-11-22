package Creational.Builder.withPriorityFields;

public class CarBuilder implements Frame, EnginePower, SeatCapacity, Color, SunRoof{
    public String frame;
    public String enginePower;
    public Integer noOfSeats;
    public String color;
    public Boolean sunRoof;

    private CarBuilder() {}

    public static Frame getInstance() {
        return new CarBuilder();
    }

    @Override
    public CarBuilder setColor(String color) {
        this.color = color;
        return this;
    }

    @Override
    public SeatCapacity setEnginePower(String enginePower) {
        this.enginePower = enginePower;
        return this;
    }

    @Override
    public EnginePower setFrame(String frame) {
        this.frame = frame;
        return this;
    }

    @Override
    public Color setSeatCapacity(Integer seatCapacity) {
        this.noOfSeats = seatCapacity;
        return this;
    }

    @Override
    public CarBuilder setSunRoof() {
        this.sunRoof = true;
        return this;
    }

    public Car build() {
        return new Car(this);
    }
}
