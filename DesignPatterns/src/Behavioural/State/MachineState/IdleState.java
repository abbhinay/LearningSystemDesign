package Behavioural.State.MachineState;

import Behavioural.State.VendingMachine;

public class IdleState implements State{
    @Override
    public void insertMoney(VendingMachine context, int money) {
        System.out.println("Money Inserted : " + context.getMoney());
        context.setState(new MoneyInsertedState());
    }

    @Override
    public void ejectMoney(VendingMachine context) {
        System.out.println("Insert Money First");
    }

    @Override
    public void selectProduct(VendingMachine context, String product) {
        System.out.println("Insert Money First");
    }

    @Override
    public void dispenseProduct(VendingMachine context) {
        System.out.println("Insert Money First");
    }
}
