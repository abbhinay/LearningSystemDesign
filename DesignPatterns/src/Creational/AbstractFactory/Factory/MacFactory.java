package Creational.AbstractFactory.Factory;

import Creational.AbstractFactory.Button.Button;
import Creational.AbstractFactory.Button.MacButton;
import Creational.AbstractFactory.EditText.EditText;
import Creational.AbstractFactory.EditText.MacEditText;

public class MacFactory implements Factory{
    @Override
    public Button getButton() {
        return new MacButton();
    }

    @Override
    public EditText getEditText() {
        return new MacEditText();
    }
}
