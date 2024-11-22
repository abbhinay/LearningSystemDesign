package Creational.Prototype;

public class Employee implements Prototype{
    private String name;
    private String address;

    public Employee(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public String getName() {
        return this.name;
    }

    public String getAddress() {
        return this.address;
    }

    public Employee clone() {
        return new Employee(this.name, this.address);
    }
}
