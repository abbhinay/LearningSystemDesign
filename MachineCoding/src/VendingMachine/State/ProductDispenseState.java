package VendingMachine.State;

import VendingMachine.Product;
import VendingMachine.Repository;

public class ProductDispenseState implements State{
    private static volatile ProductDispenseState instance;
    private ProductDispenseState(){}
    public static ProductDispenseState getInstance() {
        if(instance==null) {
            synchronized (IdleState.class) {
                if(instance==null) {
                    instance = new ProductDispenseState();
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
        Repository.getInstance().selectProduct(rackNumber);
    }

    @Override
    public void dispenseProduct() {
        Product product = Repository.getInstance().dispenseProduct();
        if(product==null) {
            System.out.println("Something went wrong");
        } else {
            System.out.println("Product dispensed : "+product.getName());
            dispenseMoney();
        }
    }
}
