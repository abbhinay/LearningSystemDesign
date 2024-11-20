package Creational.AbstractFactory.Factory;

import Creational.AbstractFactory.Button.Button;
import Creational.AbstractFactory.Button.WindowsButton;
import Creational.AbstractFactory.EditText.EditText;
import Creational.AbstractFactory.EditText.WindowsEditText;

public class WindowsFactory implements Factory{
    @Override
    public Button getButton() {
        return new WindowsButton();
    }

    @Override
    public EditText getEditText() {
        return new WindowsEditText();
    }
}
