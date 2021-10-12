import java.sql.*;
import java.util.ArrayList;

public class Connect {

    private static ArrayList<Route> routes;

    public static Connection establishConnection() {

        Connection conn = null;
        try {
            conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/boarding_pass", "root", "root");
            if (conn != null) {
                Statement statement = conn.createStatement();
                ResultSet results = statement.executeQuery("SELECT destination FROM boarding_pass.route");

                ArrayList<String> destinations = new ArrayList<>();
                while (results.next()) {
                    destinations.add(results.getString(1));
                }

                results = statement.executeQuery("SELECT trip_time FROM boarding_pass.route");

                ArrayList<String> times = new ArrayList<>();
                while (results.next()) {
                    times.add(results.getString(1));
                }

                routes = new ArrayList<>();
                if (destinations.size() == times.size()) {
                    for (int i = 0; i < destinations.size(); i++) {
                        routes.add(new Route(destinations.get(i), Double.parseDouble(times.get(i))));
                    }
                }
                routes.forEach(System.out::println);
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

    public static ArrayList<Route> getRoutes() {
        return routes;
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
                    prep.setString(1, String.valueOf(t.getBoardingPassNumber()));
                    prep.setString(2, u.getName());
                    prep.setString(3, u.getEmail());
                    prep.setString(4, u.getPhoneNumber());
                    prep.setString(5, u.getGender());
                    prep.setString(6, String.valueOf(u.getAge()));
                    prep.setString(7, u.getDestination());
                    prep.setString(8, u.getDepartureTime());
                    prep.setString(9, t.getEta());
                    prep.setString(10, String.valueOf(t.getTicketPrice()));
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
}
