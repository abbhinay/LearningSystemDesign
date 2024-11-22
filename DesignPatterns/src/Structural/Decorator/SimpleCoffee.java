package Structural.Decorator;

public class SimpleCoffee implements Coffee{
    public double getCost() {
        return 1.0;
    }

    public String getDescription() {
        return "This is Simple/Black Coffee";
    }
}
