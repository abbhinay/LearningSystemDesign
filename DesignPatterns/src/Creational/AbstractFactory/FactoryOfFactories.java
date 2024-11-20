package Creational.AbstractFactory;

import Creational.AbstractFactory.Factory.Factory;
import Creational.AbstractFactory.Factory.MacFactory;
import Creational.AbstractFactory.Factory.WindowsFactory;

public class FactoryOfFactories {
    private static volatile FactoryOfFactories instance;

    private FactoryOfFactories() {}

    public static FactoryOfFactories getInstance() {
        if(instance==null) {
            synchronized(FactoryOfFactories.class) {
                if(instance==null) {
                    instance = new FactoryOfFactories();
                }
            }
        }
        return instance;
    }

    public Factory getFactory(FactoryType factoryType) {
        switch(factoryType) {
            case MAC_FACTORY : return new MacFactory();
            case WINDOWS_FACTORY: return new WindowsFactory();
            default : throw new IllegalArgumentException("Please enter correct factory type");

        }
    }
}
