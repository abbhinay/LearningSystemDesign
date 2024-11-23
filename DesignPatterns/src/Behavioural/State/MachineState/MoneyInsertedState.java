package Behavioural.State.MachineState;

import Behavioural.State.VendingMachine;

public class MoneyInsertedState implements State{

    @Override
    public void insertMoney(VendingMachine context, int money) {
        System.out.println("Money Inserted : "+money);
    }

    @Override
    public void ejectMoney(VendingMachine context) {
        int money = context.getMoney();
        System.out.println("Money Ejected : "+money);
        context.setState(new IdleState());
    }

    @Override
    public void selectProduct(VendingMachine context, String product) {
        context.setProduct(product);
        System.out.println("Product selected : "+product);
        context.setState(new ProductSelectedState());
    }

    @Override
    public void dispenseProduct(VendingMachine context) {
        System.out.println("Please select product first");
    }
}
