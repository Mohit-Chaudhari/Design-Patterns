package creational.abstractfactory;

/**
 * @author Mohit Chaudhari
 * <a href="https://www.linkedin.com/in/mohit-chaudhari-1018/">Linkedin - Mohit Chaudhari</a>
 * Created date: 21/05/25
 */

/**
 * Multichannel Notification Suite
 * Original (Factory): Create one type of notifier like Email or SMS.
 * Abstract Factory Use Case:
 * A complete notification strategy includes multiple components: message formatter, delivery channel, and error logger.
 * These must be coordinated and vary by channel (Email, SMS, Push).
 *
 * Abstract Factory:
 *
 * NotificationFactory → createFormatter(), createSender(), createLogger()
 *
 * EmailNotificationFactory, SmsNotificationFactory, PushNotificationFactory
 */

interface Notification {
    void send();
}

interface Components {
    void create();
}

class Email implements Notification {
    @Override
    public void send() {
        System.out.println("Sending email notification");
    }
}

class SMS implements Notification {
    @Override
    public void send() {
        System.out.println("Sending SMS notification");
    }
}

class Push implements Notification {
    @Override
    public void send() {
        System.out.println("Sending Push notification");
    }
}

class Formatter implements Components {
    @Override
    public void create() {
        System.out.print("Formatter tool initiated and ");
    }
}

class Sender implements Components {
    @Override
    public void create() {
        System.out.print("Sender tool initiated and ");
    }
}

class Logger implements Components {
    @Override
    public void create() {
        System.out.print("Logger tool initiated and ");
    }
}

interface NotificationSuite {
    Components create(String component);

    Notification send();
}

class ComponentsFactory {

    public static Components getComponent(String component) {
        if (component.equalsIgnoreCase("Formatter")) {
            return new Formatter();
        } else if (component.equalsIgnoreCase("Sender")) {
            return new Sender();
        } else if (component.equalsIgnoreCase("Logger")) {
            return new Logger();
        }

        throw new IllegalArgumentException("Unsupported tool: " + component);
    }
}

class EmailNotificationFactory implements NotificationSuite {
    @Override
    public Components create(String component) {
        return ComponentsFactory.getComponent(component);
    }

    @Override
    public Notification send() {
        return new Email();
    }
}

class SmsNotificationFactory implements NotificationSuite {
    @Override
    public Components create(String component) {
        return ComponentsFactory.getComponent(component);
    }

    @Override
    public Notification send() {
        return new SMS();
    }
}

class PushNotificationFactory implements NotificationSuite {
    @Override
    public Components create(String component) {
        return ComponentsFactory.getComponent(component);
    }

    @Override
    public Notification send() {
        return new Push();
    }
}

class NotificationService {

    private Notification notification;

    private Components components;

    public NotificationService(NotificationSuite factory, String tool) {
        this.notification = factory.send();
        this.components = factory.create(tool);
    }

    public void send() {
        this.components.create();
        this.notification.send();
    }
}

public class MultichannelNotification {
    public static void main(String[] args) {
        NotificationService SMSService = new NotificationService(new SmsNotificationFactory(), "Logger");
        SMSService.send();
    }
}
