package VendingMachine;

import java.util.LinkedList;
import java.util.Queue;
import java.util.RandomAccess;
import java.util.concurrent.ConcurrentHashMap;

public class Inventory {
    private static volatile Inventory instance;
    private ConcurrentHashMap<Integer, Queue<Product>> items;
    private Inventory() {
        items = new ConcurrentHashMap<>();
    }
    public static Inventory getInstance() {
        if(instance==null) {
            synchronized (Inventory.class) {
                if(instance==null) {
                    instance = new Inventory();
                }
            }
        }
        return instance;
    }
    //Admin Operations
    public void addRack(int rackNumber) {
        this.items.put(rackNumber, new LinkedList<>());
    }
    public void removeRack(int rackNumber) {
        if(!this.items.containsKey(rackNumber)) return;
        this.items.remove(rackNumber);
    }
    public void addProduct(int rackNumber, Product product) {
        if(!this.items.containsKey(rackNumber)) return;
        this.items.get(rackNumber).offer(product);
    }
    public Product removeProduct(int rackNumber) {
        if(!items.containsKey(rackNumber) || items.get(rackNumber).isEmpty()) {
            throw new IllegalArgumentException("something went wrong");
        }
        return items.get(rackNumber).poll();
    }

    //User Operations
    public Product getProduct(int rackNumber) {
        if(!items.containsKey(rackNumber) || items.get(rackNumber).isEmpty()) return null;
        return items.get(rackNumber).poll();
    }

    public boolean validate(int rackNumber) {
        if(!items.containsKey(rackNumber) || items.get(rackNumber).isEmpty()) {
            return false;
        }
        return true;
    }

}
