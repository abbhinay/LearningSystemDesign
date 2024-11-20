package Creational.AbstractFactory.Factory;

import Creational.AbstractFactory.Button.Button;
import Creational.AbstractFactory.EditText.EditText;

public interface Factory {
    public Button getButton();
    public EditText getEditText();
}
