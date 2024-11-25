package VendingMachine.State;

import VendingMachine.Repository;

public class MoneyInsertedState implements State{
    private static volatile MoneyInsertedState instance;
    private MoneyInsertedState(){}
    public static MoneyInsertedState getInstance() {
        if(instance==null) {
            synchronized (IdleState.class) {
                if(instance==null) {
                    instance = new MoneyInsertedState();
                }
            }
        }
        return instance;
    }
    @Override
    public void insertMoney(int money) {
        Repository.getInstance().addMoney(money);
        System.out.println("Money Inserted, Total Money : "+Repository.getInstance().getMoney());
        Repository.getInstance().setCurrentState(MoneyInsertedState.getInstance());
    }

    @Override
    public void dispenseMoney() {
        System.out.println("Money dispensed : "+Repository.getInstance().getMoney());
        Repository.getInstance().resetMachine();
    }

    @Override
    public void selectProduct(int rackNumber) {
        if(Repository.getInstance().selectProduct(rackNumber)) {
            Repository.getInstance().setCurrentState(ProductDispenseState.getInstance());
        }else {
            System.out.println("Something went wrong");
        }
    }

    @Override
    public void dispenseProduct() {
        System.out.println("Select product first");
    }
}
