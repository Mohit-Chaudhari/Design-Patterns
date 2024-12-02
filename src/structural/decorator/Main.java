package structural.decorator;

import structural.decorator.toppings.CheeseBurstDecorator;
import structural.decorator.toppings.JalapenoDecorator;

/**
 * @author Mohit Chaudhari
 * <a href="https://www.linkedin.com/in/mohit-chaudhari-1018/">Linkedin - Mohit Chaudhari</a>
 * Created date: 03/12/24
 */
public class Main {

    public static void main(String[] args) {
        Pizza pizza = new JalapenoDecorator(new CheeseBurstDecorator(new BasePizza()));
        System.out.println(pizza.bake());
    }
}
