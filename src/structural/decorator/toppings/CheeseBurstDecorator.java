package structural.decorator.toppings;

import structural.decorator.Pizza;

/**
 * @author Mohit Chaudhari
 * <a href="https://www.linkedin.com/in/mohit-chaudhari-1018/">Linkedin - Mohit Chaudhari</a>
 * Created date: 03/12/24
 */
public class CheeseBurstDecorator extends PizzaDecorator {
    public CheeseBurstDecorator(Pizza pizza) {
        super(pizza);
    }

    public String bake() {
        return pizza.bake() + addCheese();
    }

    private String addCheese() {
        return " + Cheese";
    }
}
