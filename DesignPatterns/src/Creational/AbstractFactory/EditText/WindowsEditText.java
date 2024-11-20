package Creational.AbstractFactory.EditText;

public class WindowsEditText implements EditText{
    @Override
    public void writeText() {
        System.out.println("Writing on Windows");
    }
}
