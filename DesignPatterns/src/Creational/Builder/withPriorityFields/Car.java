package Creational.Builder.withPriorityFields;

import Creational.Builder.withPriorityFields.CarBuilder;

public class Car {
    private final String frame;
    private final String enginePower;
    private final Integer noOfSeats;
    private final String color;
    private final Boolean sunRoof;

    public Car(CarBuilder builder) {
        this.frame = builder.frame;
        this.enginePower = builder.enginePower;
        this.noOfSeats = builder.noOfSeats;
        this.color = builder.color;
        this.sunRoof = builder.sunRoof;
    }

    public String getFrame() {
        return this.frame;
    }

    public String getEnginePower() {
        return this.enginePower;
    }

    public Integer getNoOfSeats() {
        return this.noOfSeats;
    }

    public String getColor() {
        return this.color;
    }

    public Boolean getSunRoof() {
        return this.sunRoof;
    }
}
