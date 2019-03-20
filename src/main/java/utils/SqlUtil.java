package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SqlUtil {

    private static final String username = "root";
    private static final String password = "";
    private static final String dbUrl = "jdbc:mysql://localhost:3306/disc_golf_courses";

    public static Connection getConnection() throws SQLException {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(dbUrl, username, password);
            System.out.println("Connection Established to MYSQL Database");
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } finally {
            connection.close();
        }
        return connection;
    }
}
