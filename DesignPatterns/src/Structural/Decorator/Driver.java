package Structural.Decorator;

public class Driver {
    public static void main(String[] args) {
        Coffee simpleCoffee = new SimpleCoffee();
        System.out.println(simpleCoffee.getDescription()+ " cost = "+simpleCoffee.getCost());

        Coffee coffeeWithMilk = new Milk(new SimpleCoffee());
        System.out.println(coffeeWithMilk.getDescription()+ " cost = "+coffeeWithMilk.getCost());

        Coffee coffeeWithMilkAndSugar = new Sugar(new Milk(new SimpleCoffee()));
        System.out.println(coffeeWithMilkAndSugar.getDescription()+ " cost = "+coffeeWithMilkAndSugar.getCost());
    }
}
