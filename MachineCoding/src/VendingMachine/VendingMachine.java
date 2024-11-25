package VendingMachine;

public class VendingMachine {
    private static volatile VendingMachine instance;
    private VendingMachine(){}
    public static VendingMachine getInstance() {
        if(instance==null) {
            synchronized(VendingMachine.class) {
                if(instance==null) {
                    instance = new VendingMachine();
                }
            }
        }
        return instance;
    }
    // User interaction methods
    public void insertMoney(int money) {
        Repository.getInstance().getCurrentState().insertMoney(money);
    }
    public void dispenseMoney() {
        Repository.getInstance().getCurrentState().dispenseMoney();
    }
    public void selectProduct(int rackNumber){
        Repository.getInstance().getCurrentState().selectProduct(rackNumber);
    }
    public void dispenseProduct(){
        Repository.getInstance().getCurrentState().dispenseProduct();
    }
}
