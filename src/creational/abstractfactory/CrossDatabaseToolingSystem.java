package creational.abstractfactory;

/**
 * @author Mohit Chaudhari
 * <a href="https://www.linkedin.com/in/mohit-chaudhari-1018/">Linkedin - Mohit Chaudhari</a>
 * Created date: 22/05/25
 */

/**
 * Cross-Database Tooling System
 * Original (Factory): Load a single database driver.
 * Abstract Factory Use Case:
 * A complete integration with a database requires several related components:
 * connection, query builder, and ORM adapter. These vary by database (MySQL, PostgreSQL, MongoDB)
 * and must be used as a unit.
 *
 * Abstract Factory:
 *
 * DatabaseFactory → createConnection(), createQueryBuilder(), createORMAdapter()
 *
 * MySQLFactory, PostgreSQLFactory, MongoDBFactory
 */

interface SQL {
    void init();
}

class MySQL implements SQL {
    @Override
    public void init() {
        System.out.println("MySQL Connection initiated");
    }
}

class PostgreSQL implements SQL {
    @Override
    public void init() {
        System.out.println("PostgreSQL connection initiated");
    }
}

class MongoDB implements SQL {
    @Override
    public void init() {
        System.out.println("MongoDB connection initiated");
    }
}

interface DatabaseTools {
    void connect();
}

class ORMAdapter implements DatabaseTools {
    @Override
    public void connect() {
        System.out.println("ORM Adapter initiated");
    }
}

class QueryBuilder implements DatabaseTools {
    @Override
    public void connect() {
        System.out.println("Query builder initiated");
    }
}

class Connection implements DatabaseTools {
    @Override
    public void connect() {
        System.out.println("Connection initiated");
    }
}

interface Database {
    DatabaseTools initDatabaseTools(String tool);

    SQL initSQL();
}

class DatabaseToolsFactory {

    public static DatabaseTools getDatabaseTool(String tool) {
        if (tool.equalsIgnoreCase("orm")) {
            return new ORMAdapter();
        } else if (tool.equalsIgnoreCase("connection")) {
            return new Connection();
        } else if (tool.equalsIgnoreCase("querybuilder")) {
            return new QueryBuilder();
        }
        throw new IllegalArgumentException("Unsupported tool: " + tool);
    }
}

class MySQLFactory implements Database {
    @Override
    public DatabaseTools initDatabaseTools(String tool) {
        return DatabaseToolsFactory.getDatabaseTool(tool);
    }

    @Override
    public SQL initSQL() {
        return new MySQL();
    }
}

class MongoDBFactory implements Database {
    @Override
    public DatabaseTools initDatabaseTools(String tool) {
        return DatabaseToolsFactory.getDatabaseTool(tool);
    }

    @Override
    public SQL initSQL() {
        return new MongoDB();
    }
}

class PostgreSQLFactory implements Database {
    @Override
    public DatabaseTools initDatabaseTools(String tool) {
        return DatabaseToolsFactory.getDatabaseTool(tool);
    }

    @Override
    public SQL initSQL() {
        return new PostgreSQL();
    }
}

class CrossDatabaseToolingService {

    private SQL sql;

    private DatabaseTools dbTools;

    public CrossDatabaseToolingService(Database database, String tool) {
        this.sql = database.initSQL();
        this.dbTools = database.initDatabaseTools(tool);
    }

    public void createConnection() {
        this.sql.init();
        this.dbTools.connect();
    }
}

public class CrossDatabaseToolingSystem {

    public static void main(String[] args) {
        CrossDatabaseToolingService mongodb = new CrossDatabaseToolingService(new MongoDBFactory(), "orm");
        mongodb.createConnection();
    }
}
