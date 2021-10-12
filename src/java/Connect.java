import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * this class handles the database that is connected through a local mysql server.
 * It retrieves route information and stores ticket information to and from this database.
 */
public class Connect {

    /**
     * a list that holds all the connections that the user can go to and the time they take to reach
     */
    private static Map<String, Double> routes = new HashMap<>();

    /**
     * establishes a connection to the database on a local mysql server
     */
    public static void establishConnection(){

        Connection conn = null;
        try {
            conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/boarding_pass", "root", "root");
            if (conn != null) {
                collectInfo(conn);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (conn != null && !conn.isClosed()) {
                    conn.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return conn;
    }

    /**
     * gathers information stored in the database and places it into the route instance variable
     * @param conn the connection to the database
     * @throws SQLException for sql queries
     */
    private static void collectInfo(Connection conn) throws SQLException {
        Statement statement = conn.createStatement();
        ResultSet results = statement.executeQuery("SELECT destination FROM boarding_pass.route");

        ArrayList<String> destinations = new ArrayList<>();
        while(results.next()){
            destinations.add(results.getString(1));
        }

        results = statement.executeQuery("SELECT trip_time FROM boarding_pass.route");

        ArrayList<String> times = new ArrayList<>();
        while(results.next()){
            times.add(results.getString(1));
        }

        if(destinations.size() == times.size()){
            for (int i=0; i< destinations.size(); i++){
                routes.put(destinations.get(i), Double.parseDouble(times.get(i)));
            }
        }
    }

    /**
     * Insert into the ticket table
     * @param u - User object containing the data to be inserted
     * @param t - Ticket object containing the data to be inserted
     */
    public static Connection establishSave(User u, Ticket t) {

        Connection conn = null;
        try {
            conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/boarding_pass", "root", "root");
            if (conn != null) {
                String temp = "INSERT INTO ticket (boardingPassNumber, " +
                        "name, email, phoneNumber, gender, " +
                        "age, destination, departureTime, eta, ticketPrice) " +
                        "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
                PreparedStatement prep = conn.prepareStatement(temp);
                {
                    prep.setInt(1, t.getBoardingPassNumber());
                    prep.setString(2, u.getName());
                    prep.setString(3, u.getEmail());
                    prep.setString(4, u.getPhoneNumber());
                    prep.setString(5, u.getGender());
                    prep.setInt(6,  u.getAge());
                    prep.setString(7, u.getDestination());
                    prep.setString(8, u.getDepartureTime());
                    prep.setString(9, t.getEta());
                    prep.setDouble(10, t.getTicketPrice());
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (conn != null && !conn.isClosed()) {
                    conn.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return conn;
    }

    public static Map<String, Double> getRoutes() {
        return routes;
    }

    public static void setRoutes(Map<String, Double> routes) {
        Connect.routes = routes;
    }
}
