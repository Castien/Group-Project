import java.sql.*;
import java.util.ArrayList;

public class Connect {

    private static ArrayList<Route> routes;

    public static void establishConnection(){

        Connection conn = null;
        try {
            conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/boarding_pass","root","root");
            if (conn != null) {
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

                routes = new ArrayList<>();
                if(destinations.size() == times.size()){
                    for (int i=0; i< destinations.size(); i++){
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
    }

    public static ArrayList<Route> getRoutes() {
        return routes;
    }
}
