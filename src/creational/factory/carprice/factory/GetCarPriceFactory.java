package creational.factory.carprice.factory;

import creational.factory.carprice.enums.CarTypeEnum;
import creational.factory.carprice.factory.impl.DieselCar;
import creational.factory.carprice.factory.impl.ElectricCar;
import creational.factory.carprice.factory.impl.PetrolCar;

/**
 * @author Mohit Chaudhari
 * <a href="https://www.linkedin.com/in/mohit-chaudhari-1018/">Linkedin - Mohit Chaudhari</a>
 * Created date: 22/02/24
 */
public class GetCarPriceFactory {

    public CarPrice getCarPrice(CarTypeEnum carType) {
        if (CarTypeEnum.DIESEL.equals(carType)) {
            return new DieselCar();
        } else if (CarTypeEnum.PETROL.equals(carType)) {
            return new PetrolCar();
        } else if (CarTypeEnum.ELECTRIC.equals(carType)) {
            return new ElectricCar();
        } else {
            throw new IllegalArgumentException("Invalid car type!!!");
        }
    }
}
