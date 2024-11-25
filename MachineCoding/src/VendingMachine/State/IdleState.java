package VendingMachine.State;

import VendingMachine.Repository;

public class IdleState implements State{
    private static volatile IdleState instance;
    private IdleState(){}
    public static IdleState getInstance() {
        if(instance==null) {
            synchronized (IdleState.class) {
                if(instance==null) {
                    instance = new IdleState();
                }
            }
        }
        return instance;
    }
    @Override
    public void insertMoney(int money) {
        Repository.getInstance().addMoney(money);
        System.out.println("MOney Inserted, Total Money : "+Repository.getInstance().getMoney());
        Repository.getInstance().setCurrentState(MoneyInsertedState.getInstance());
    }

    @Override
    public void dispenseMoney() {
        System.out.println("Insert money first");
    }

    @Override
    public void selectProduct(int rackNumber) {
        System.out.println("Insert money first");
    }

    @Override
    public void dispenseProduct() {
        System.out.println("Insert money first");
    }
}
