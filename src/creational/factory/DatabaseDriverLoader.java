package creational.factory;

/**
 * @author Mohit Chaudhari
 * <a href="https://www.linkedin.com/in/mohit-chaudhari-1018/">Linkedin - Mohit Chaudhari</a>
 * Created date: 20/05/25
 */

import javax.xml.crypto.Data;

/**
 * Database Driver Loader
 * Problem Statement:
 * A data access layer needs to support different databases like MySQL, PostgreSQL, and MongoDB. Depending on user configuration,
 * the system should be able to load the appropriate database driver and establish connections without exposing the client code to the specific driver classes.
 *
 * Solution via Factory Pattern:
 * Create a database connection factory that returns the correct driver instance based on the configuration file or connection string.
 */

interface Database {
    void load();
}

class PostgreSQL implements Database {
    @Override
    public void load() {
        System.out.println("Instantiating PostgreSQL driver");
    }
}

class MySQL implements Database {
    @Override
    public void load() {
        System.out.println("Instantiating MySQL driver");
    }
}

class MongoDB implements Database {
    @Override
    public void load() {
        System.out.println("Instantiating MongoDB driver");
    }
}

class DatabaseFactory {
    public static Database getDatabaseDriver(String type) {
        if (type.equalsIgnoreCase("mongodb")) {
            return new MongoDB();
        } else if (type.equalsIgnoreCase("mysql")) {
            return new MySQL();
        } else if (type.equalsIgnoreCase("postgresql")) {
            return new PostgreSQL();
        }
        throw new IllegalArgumentException("Unsupported database");
    }
}

class DatabaseLoaderService {
    public void init(String type) {
        Database database = DatabaseFactory.getDatabaseDriver(type);
        database.load();
    }
}

public class DatabaseDriverLoader {

    public static void main(String[] args) {
        DatabaseLoaderService databaseLoaderService = new DatabaseLoaderService();
        databaseLoaderService.init("mysql");
        databaseLoaderService.init("postgresql");
        databaseLoaderService.init("mongodb");
        databaseLoaderService.init("dynamodb");
    }
}
