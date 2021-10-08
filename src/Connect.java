import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connect {

    /**
     * Get database connection when needed
     * @return a Connection object
     * @throws SQLException
     */
    public static Connection getConnection() throws SQLException {
        Connection conn = null;

        final String url = "jdbc:mysql://LocalServer:3306/boarding_pass";
        final String user = "guest";
        final String password = "qwerty123456!";

        // create a connection to the database
        conn = DriverManager.getConnection(url, user, password);
        return conn;
    }
}