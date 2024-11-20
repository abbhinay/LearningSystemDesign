package Creational.Factory;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Driver {
    public static void main(String[] args) {
        Factory factory = Factory.getInstance();
        Notification emailNotification = factory.getNotification(NotificationType.EMAIL);
        emailNotification.sendNotification();
        Notification pushNotification = factory.getNotification(NotificationType.PUSH);
        pushNotification.sendNotification();
        Notification smsNotification = factory.getNotification(NotificationType.SMS);
        smsNotification.sendNotification();
    }
}
