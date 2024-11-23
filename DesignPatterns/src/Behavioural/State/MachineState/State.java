package Behavioural.State.MachineState;

import Behavioural.State.VendingMachine;

public interface State {
    public void insertMoney(VendingMachine context, int money);
    public void ejectMoney(VendingMachine context);
    public void selectProduct(VendingMachine context, String product);
    public void dispenseProduct(VendingMachine context);
}
