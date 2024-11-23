package Behavioural.State.MachineState;

import Behavioural.State.VendingMachine;

public class ProductSelectedState implements State{
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
        System.out.println("Product already selected : "+context.getProduct());
    }

    @Override
    public void dispenseProduct(VendingMachine context) {
        String product = context.getProduct();
        context.setProduct(null);
        System.out.println("Product dispensed : "+product);
        context.setState(new IdleState());
    }
}
