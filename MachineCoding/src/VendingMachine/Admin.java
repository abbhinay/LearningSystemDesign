package VendingMachine;

public class Admin {
    private static volatile Admin instance;
    private Admin(){}
    public static Admin getInstance() {
        if(instance==null) {
            synchronized (Admin.class) {
                if(instance==null) {
                    instance = new Admin();
                }
            }
        }
        return instance;
    }
    public void initiate() {
        VendingMachine vendingMachine = VendingMachine.getInstance();
        Inventory inventory = Inventory.getInstance();
        for(int i=1; i<5; i++) {
            inventory.addRack(i);
        }
        for(int i=1; i<=10; i++) {
            inventory.addProduct(1, new Product("Pepsi", 20));
        }
        for(int i=1; i<=10; i++) {
            inventory.addProduct(2, new Product("Coke", 30));
        }
        for(int i=1; i<=10; i++) {
            inventory.addProduct(3, new Product("Lays", 10));
        }
        for(int i=1; i<=10; i++) {
            inventory.addProduct(4, new Product("Chips", 5));
        }
    }
}
