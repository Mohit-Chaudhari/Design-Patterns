package creational.factory;

/**
 * @author Mohit Chaudhari
 * <a href="https://www.linkedin.com/in/mohit-chaudhari-1018/">Linkedin - Mohit Chaudhari</a>
 * Created date: 20/05/25
 */

/**
 * Notification Service Integration
 * Problem Statement:
 * A notification system needs to send alerts through different channels such as Email, SMS, and Push Notifications. The implementation of each channel varies, and you need a clean way to manage and extend these notification types without modifying existing code.
 *
 * Solution via Factory Pattern:
 * Use a factory to produce different notification handler objects based on the user’s preferences or system configuration.
 */

interface Notification {
    void send();
}

class EmailProvider implements Notification {
    @Override
    public void send() {
        System.out.println("Sending notification through email provider");
    }
}

class SMSProvider implements Notification {
    @Override
    public void send() {
        System.out.println("Sending notification through SMS provider");
    }
}

class PushNotification implements Notification {
    @Override
    public void send() {
        System.out.println("Sending notification through push notification provider");
    }
}

class NotificationFactory {

    public static Notification send(String type) {
        if (type.equalsIgnoreCase("sms")) {
            return new SMSProvider();
        } else if (type.equalsIgnoreCase("email")) {
            return new EmailProvider();
        } else if (type.equalsIgnoreCase("push")) {
            return new PushNotification();
        }
        throw new IllegalArgumentException("Unsupported notification type: " + type);
    }
}

class NotificationService {
    public void send(String type) {
        Notification notification = NotificationFactory.send(type);
        notification.send();
    }
}

public class NotificationManagement {

    public static void main(String[] args) {
        NotificationService notificationService = new NotificationService();
        notificationService.send("sms");
        notificationService.send("email");
        notificationService.send("push");
        notificationService.send("whatsapp");
    }
}
