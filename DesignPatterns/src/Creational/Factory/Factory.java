package Creational.Factory;

public class Factory {
    private static volatile Factory instance;

    private Factory() {}

    public static Factory getInstance() {
        if(instance==null) {
            synchronized(Factory.class) {
                if(instance==null) {
                    instance = new Factory();
                }
            }
        }
        return instance;
    }

    public Notification getNotification(NotificationType notificationType) {
        switch(notificationType) {
            case SMS : return new SmsNotification();
            case EMAIL: return new EmailNotification();
            case PUSH: return new PushNotification();
            default: throw new IllegalArgumentException("provide correct notification type");
        }
    }
}
