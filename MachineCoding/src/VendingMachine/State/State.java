package VendingMachine.State;

public interface State {
    void insertMoney(int money);
    void dispenseMoney();
    void selectProduct(int rackNumber);
    void dispenseProduct();
}
