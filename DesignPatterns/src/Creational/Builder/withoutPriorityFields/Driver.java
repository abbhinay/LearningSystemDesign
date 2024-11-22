package Creational.Builder.withoutPriorityFields;

public class Driver {
    public static void main(String[] args) {
        CarBuilder builder = CarBuilder.getInstance();

        //Building car without sun roof.
        //We are painting the car without building the frame of the car. So, the heirarchy is not followe here.
        //To make sure heirarchy is followed, withPriorityField is used.
        Car car = builder.setColor("red").setFrame("carbonFiber").setEnginePower("200cc").setNoOfSeats(4).build();
        System.out.println(car.getColor());
    }
}
