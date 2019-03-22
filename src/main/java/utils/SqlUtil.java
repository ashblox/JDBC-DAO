package utils;

import java.sql.Connection;
import com.mysql.cj.jdbc.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

import static sun.plugin.javascript.navig.JSType.URL;

public class SqlUtil {

    private static final String username = "root";
    private static final String password = "";
    private static final String dbUrl = "jdbc:mysql://localhost:3306/disc_golf_courses?useLegacyDatetimeCode=false&serverTimezone=UTC";

    public static Connection getConnection()
    {
        Connection connection = null;
        try {
            DriverManager.registerDriver(new Driver());
            System.out.println("Established Connection to MySQL");
            connection = DriverManager.getConnection(dbUrl, username, password);
        } catch (SQLException e) {
            printError(e);
        }
        return connection;
    }

    public static void printError(SQLException e) {
        System.err.println(e.getMessage());
    }

    public static void main(String[] args) throws SQLException {
        Connection connection = getConnection();
        connection.close();
    }

}
