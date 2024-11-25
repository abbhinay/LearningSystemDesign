package VendingMachine;

public class Driver {
    public static void main(String[] args) {
        Admin admin = Admin.getInstance();
        admin.initiate();

        VendingMachine machine = VendingMachine.getInstance();
        machine.insertMoney(100);
        machine.selectProduct(2);
        machine.dispenseProduct();
    }
}
