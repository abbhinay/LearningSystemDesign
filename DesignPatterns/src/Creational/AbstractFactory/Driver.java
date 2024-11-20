package Creational.AbstractFactory;

import Creational.AbstractFactory.Button.Button;
import Creational.AbstractFactory.EditText.EditText;
import Creational.AbstractFactory.Factory.Factory;

public class Driver {
    public static void main(String[] args) {
        FactoryOfFactories factoryOfFactories = FactoryOfFactories.getInstance();
        Factory macFactory = factoryOfFactories.getFactory(FactoryType.MAC_FACTORY);
        Factory windowsFactory = factoryOfFactories.getFactory(FactoryType.WINDOWS_FACTORY);

        Button macButton = macFactory.getButton();
        EditText macEditText = macFactory.getEditText();

        macButton.click();
        macEditText.writeText();

        Button windowsButton = windowsFactory.getButton();
        EditText windowsEditText = windowsFactory.getEditText();

        windowsButton.click();
        windowsEditText.writeText();
    }
}
