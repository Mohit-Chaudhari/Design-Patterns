package structural.decorator.toppings;

import structural.decorator.Pizza;

/**
 * @author Mohit Chaudhari
 * <a href="https://www.linkedin.com/in/mohit-chaudhari-1018/">Linkedin - Mohit Chaudhari</a>
 * Created date: 03/12/24
 */
public class JalapenoDecorator extends PizzaDecorator {
    public JalapenoDecorator(Pizza pizza) {
        super(pizza);
    }

    public String bake() {
        return pizza.bake() + addJalapeno();
    }

    private String addJalapeno() {
        return " + Jalapeno";
    }
}
