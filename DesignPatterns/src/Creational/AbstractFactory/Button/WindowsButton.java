package Creational.AbstractFactory.Button;

public class WindowsButton implements Button{
    @Override
    public void click() {
        System.out.println("Windows button clicked");
    }
}
