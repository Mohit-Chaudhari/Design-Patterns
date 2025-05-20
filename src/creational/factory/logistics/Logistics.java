package creational.factory.logistics;

/**
 * @author Mohit Chaudhari
 * <a href="https://www.linkedin.com/in/mohit-chaudhari-1018/">Linkedin - Mohit Chaudhari</a>
 * Created date: 20/05/25
 */

interface Logistic {
    void send();
}

class Road implements Logistic {
    @Override
    public void send() {
        System.out.println("Sending by road logic");
    }
}

class Air implements Logistic {
    @Override
    public void send() {
        System.out.println("Sending by Air logic");
    }
}

class Train implements Logistic {
    @Override
    public void send() {
        System.out.println("Sending by Train logic");
    }
}

class LogisticsFactory {
    public static Logistic getLogistics(String mode) {
        if (mode.equalsIgnoreCase("air")) {
            return new Air();
        } else if (mode.equalsIgnoreCase("train")) {
            return new Train();
        } else if (mode.equalsIgnoreCase("road")) {
            return new Road();
        }

        throw new IllegalArgumentException("Invalid logistics mode " + mode);
    }
}

class LogisticsService {
    public void send(String mode) {
        Logistic logistic = LogisticsFactory.getLogistics(mode);
        logistic.send();
    }
}
public class Logistics {
    public static void main(String[] args) {
        LogisticsService logisticsService = new LogisticsService();
        logisticsService.send("air");
        logisticsService.send("road");
        logisticsService.send("train");
        logisticsService.send("Scooter");
    }
}
