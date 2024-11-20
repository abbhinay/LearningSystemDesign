package Creational.Factory;

public class PushNotification implements Notification{
    @Override
    public void sendNotification() {
        System.out.println("Sending Push Notification");
    }
}
