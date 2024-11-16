package creational.singleton.jdbc.lazy.threadunsafe;

/**
 * @author Mohit Chaudhari
 * <a href="https://www.linkedin.com/in/mohit-chaudhari-1018/">Linkedin - Mohit Chaudhari</a>
 * Created date: 17/11/24
 */
public class ThreadUnsafeJDBC {

    private ThreadUnsafeJDBC() {}

    private static ThreadUnsafeJDBC jdbc;

    public static ThreadUnsafeJDBC getInstance() {
        if(jdbc == null) {
            jdbc = new ThreadUnsafeJDBC();
        }
        return jdbc;
    }
}
