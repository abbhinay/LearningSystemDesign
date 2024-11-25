package VendingMachine;

import VendingMachine.State.IdleState;
import VendingMachine.State.State;

public class Repository {
    private static volatile Repository instance;
    private int money;
    private int selectedRackNumber;
    private State currentState;
    private Repository(){
        resetMachine();
    }
    public static Repository getInstance() {
        if(instance==null) {
            synchronized (Repository.class) {
                if(instance==null) {
                    instance = new Repository();
                }
            }
        }
        return instance;
    }
    public State getCurrentState() {
        return this.currentState;
    }
    public void resetMachine() {
        this.money = 0;
        this.currentState = IdleState.getInstance();
    }
    public void setCurrentState(State state) {
        this.currentState = state;
    }
    public void addMoney(int money) {
        this.money += money;
    }
    public int getMoney() {
        return this.money;
    }
    public boolean selectProduct(int rackNumber) {
        if(!Inventory.getInstance().validate(rackNumber)) return false;
        this.selectedRackNumber = rackNumber;
        return true;
    }
    public Product dispenseProduct() {
        Product product = Inventory.getInstance().removeProduct(selectedRackNumber);
        this.money -= product.getPrice();
        return product;
    }
}
