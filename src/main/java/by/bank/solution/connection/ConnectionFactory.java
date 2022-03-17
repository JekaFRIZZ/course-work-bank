package by.bank.solution.connection;

import org.postgresql.Driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    private static final String MYSQL_URL = "jdbc:postgresql://localhost:5432/course-work-bank";
    private static final String MYSQL_USERNAME = "postgres";
    private static final String MYSQL_PASSWORD = "12345";

    public ConnectionFactory() {
        try {
            DriverManager.registerDriver(new Driver());
        } catch (SQLException e) {
            throw new RuntimeException();
        }
    }

    public static Connection create() {
        try {
            return DriverManager.getConnection(MYSQL_URL, MYSQL_USERNAME, MYSQL_PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException();
        }
    }
}
