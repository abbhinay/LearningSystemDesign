package Behavioural.State;

import Behavioural.State.MachineState.IdleState;
import Behavioural.State.MachineState.State;

public class VendingMachine {
    private int money;
    private String product;
    private State currentState;
    public VendingMachine() {
        this.money = 0;
        this.product = null;
        this.currentState = new IdleState();
    }

    public int getMoney() {
        return this.money;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public String getProduct() {
        return this.product;
    }

    public void setState(State state) {
        this.currentState = state;
    }

    public void insertMoney(int money) {
        this.money += money;
        currentState.insertMoney(this, money);
    }
    public void ejectMoney() {
        currentState.ejectMoney(this);
        this.money = 0;
    }
    public void selectProduct(String product) {
        currentState.selectProduct(this, product);
    }
    public void dispenseProduct() {
        currentState.dispenseProduct(this);
        this.money = 0;
    }
}
