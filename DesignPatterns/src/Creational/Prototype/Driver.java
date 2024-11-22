package Creational.Prototype;

public class Driver {
    public static void main(String[] args) {
        Employee employee = new Employee("John", "21 Jump Street");

        Employee employeeClone = employee.clone();

        System.out.println("employee reference "+employee);
        System.out.println("cloned employee reference "+employeeClone);
    }
}
