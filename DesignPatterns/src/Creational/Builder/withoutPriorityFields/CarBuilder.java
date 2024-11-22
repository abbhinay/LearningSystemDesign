package Creational.Builder.withoutPriorityFields;

public class CarBuilder {
    public String frame;
    public String enginePower;
    public Integer noOfSeats;
    public String color;
    public Boolean sunRoof;

    private CarBuilder() {}

    public static CarBuilder getInstance() {
        return new CarBuilder();
    }

    public CarBuilder setFrame(String frame) {
        this.frame = frame;
        return this;
    }

    public CarBuilder setEnginePower(String enginePower) {
        this.enginePower = enginePower;
        return this;
    }

    public CarBuilder setNoOfSeats(Integer noOfSeats) {
        this.noOfSeats = noOfSeats;
        return this;
    }

    public CarBuilder setColor(String color) {
        this.color = color;
        return this;
    }

    public CarBuilder setSunRoof(Boolean required) {
        this.sunRoof = required;
        return this;
    }

    public Car build() {
        return new Car(this);
    }
}
