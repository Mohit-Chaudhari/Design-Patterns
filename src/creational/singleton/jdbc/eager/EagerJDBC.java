package creational.singleton.jdbc.eager;

/**
 * @author Mohit Chaudhari
 * <a href="https://www.linkedin.com/in/mohit-chaudhari-1018/">Linkedin - Mohit Chaudhari</a>
 * Created date: 17/11/24
 */
public class EagerJDBC {

    private EagerJDBC() {}

    private static EagerJDBC jdbc = new EagerJDBC();

    public static EagerJDBC getInstance() {
        return jdbc;
    }
}
