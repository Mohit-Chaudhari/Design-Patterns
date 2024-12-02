package structural.decorator;

/**
 * @author Mohit Chaudhari
 * <a href="https://www.linkedin.com/in/mohit-chaudhari-1018/">Linkedin - Mohit Chaudhari</a>
 * Created date: 03/12/24
 */
public class BasePizza implements Pizza {
    @Override
    public String bake() {
        return "base pizza";
    }
}
