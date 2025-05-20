package creational.factory;

/**
 * @author Mohit Chaudhari
 * <a href="https://www.linkedin.com/in/mohit-chaudhari-1018/">Linkedin - Mohit Chaudhari</a>
 * Created date: 20/05/25
 */

/**
 * Vehicle Assembly Management
 * Problem Statement:
 * In a vehicle manufacturing system, there are different types of vehicles like cars, bikes, and trucks, each with its own complex setup process.
 * The system must support the dynamic creation of these vehicles without knowing the exact class to instantiate in advance.
 *
 * Solution via Factory Pattern:
 * Implement a vehicle factory that decides which vehicle class to instantiate based on input parameters like vehicle type or model.
 */
interface Vehicle {
    void create();
}

class Bike implements Vehicle {
    @Override
    public void create() {
        System.out.println("Creating Bike");
    }
}

class Car implements Vehicle {
    @Override
    public void create() {
        System.out.println("Creating Car");
    }
}

class Truck implements Vehicle {
    @Override
    public void create() {
        System.out.println("Creating Truck");
    }
}

class VehicleFactory {

    public static Vehicle getVehicleInstance(String vehicleType) {
        if (vehicleType.equalsIgnoreCase("bike")) {
            return new Bike();
        } else if (vehicleType.equalsIgnoreCase("car")) {
            return new Car();
        } else if (vehicleType.equalsIgnoreCase("truck")) {
            return new Truck();
        }
        throw new IllegalArgumentException("Unsupported vehicle: " + vehicleType);
    }
}

class VehicleAssemblyService {
    public void create(String type) {
        Vehicle vehicle = VehicleFactory.getVehicleInstance(type);
        vehicle.create();
    }
}

public class VehicleAssemblyManagement {

    public static void main(String[] args) {
        VehicleAssemblyService vehicleAssemblyService = new VehicleAssemblyService();
        vehicleAssemblyService.create("car");
        vehicleAssemblyService.create("bike");
        vehicleAssemblyService.create("truck");
        vehicleAssemblyService.create("cycle");
    }
}
