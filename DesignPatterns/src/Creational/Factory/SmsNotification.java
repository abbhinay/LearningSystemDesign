package Creational.Factory;

public class SmsNotification implements Notification{
    @Override
    public void sendNotification() {
        System.out.println("Sending SMS Notification");
    }
}
