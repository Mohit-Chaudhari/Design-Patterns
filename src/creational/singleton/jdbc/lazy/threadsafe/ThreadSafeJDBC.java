package creational.singleton.jdbc.lazy.threadsafe;

/**
 * @author Mohit Chaudhari
 * <a href="https://www.linkedin.com/in/mohit-chaudhari-1018/">Linkedin - Mohit Chaudhari</a>
 * Created date: 17/11/24
 */
public class ThreadSafeJDBC {

    private ThreadSafeJDBC() {}

    private static ThreadSafeJDBC jdbc;

    public static ThreadSafeJDBC getInstance() {
        synchronized (ThreadSafeJDBC.class) {
            if(jdbc == null) {
                jdbc = new ThreadSafeJDBC();
            }
        }
        return jdbc;
    }
}
