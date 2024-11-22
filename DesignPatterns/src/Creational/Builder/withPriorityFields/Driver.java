package Creational.Builder.withPriorityFields;

public class Driver {
    public static void main(String[] args) {
        //Once we get the instance, we provide Frame instance so that it should call it first.
        //setFrame provide EnginePower instnace, so only engine power can be set.
        //setColor and setSunRoof provide CarBuilder instance, so that build method can be called.
        Car car1 = CarBuilder.getInstance().setFrame("steel").setEnginePower("200cc").setSeatCapacity(4).setColor("blue").build();
        Car car2 = CarBuilder.getInstance().setFrame("carbon fiber").setEnginePower("400cc").setSeatCapacity(6).setColor("white").setSunRoof().build();

        System.out.println(car1.getColor());
        System.out.println(car2.getColor());
    }
}
