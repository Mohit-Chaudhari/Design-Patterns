package creational.factory.carprice.factory.impl;

import creational.factory.carprice.factory.CarPrice;

/**
 * @author Mohit Chaudhari
 * <a href="https://www.linkedin.com/in/mohit-chaudhari-1018/">Linkedin - Mohit Chaudhari</a>
 * Created date: 22/02/24
 */
public class PetrolCar implements CarPrice {

    @Override
    public void getPrice() {
        System.out.println("Petrol car price is 200000");
    }
}
