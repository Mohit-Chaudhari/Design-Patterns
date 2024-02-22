package creational.factory.carprice;

import creational.factory.carprice.enums.CarTypeEnum;
import creational.factory.carprice.factory.CarPrice;
import creational.factory.carprice.factory.GetCarPriceFactory;

/**
 * @author Mohit Chaudhari
 * <a href="https://www.linkedin.com/in/mohit-chaudhari-1018/">Linkedin - Mohit Chaudhari</a>
 * Created date: 22/02/24
 */
public class GetCarPrice {
    public static void main(String[] args) {
        GetCarPriceFactory factory = new GetCarPriceFactory();

        System.out.println("Collecting car prices");
        CarPrice diesel = factory.getCarPrice(CarTypeEnum.DIESEL);
        CarPrice petrol = factory.getCarPrice(CarTypeEnum.PETROL);
        CarPrice electric = factory.getCarPrice(CarTypeEnum.ELECTRIC);

        diesel.getPrice();
        petrol.getPrice();
        electric.getPrice();
    }
}
