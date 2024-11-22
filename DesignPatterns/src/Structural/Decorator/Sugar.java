package Structural.Decorator;

public class Sugar extends CoffeeDecorator{
    public Sugar(Coffee coffee) {
        super(coffee);
    }

    public double getCost() {
        return super.getCost() + 0.2;
    }

    public String getDescription() {
        return super.getDescription() + " with sugar topup";
    }
}
