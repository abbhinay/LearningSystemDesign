package Behavioural.State;

public class Driver {
    public static void main(String[] args) {
        VendingMachine machine = new VendingMachine();

        machine.insertMoney(20);
        machine.selectProduct("Coke");
        machine.dispenseProduct();
    }
}
