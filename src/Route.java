import java.util.HashMap;
import java.util.Map;

public class Route {
    private String destination;
    private double trip_time;

    private static Map<String, Double> time_map = new HashMap<String, Double>();

    public Route(String destination, double trip_time) {
        this.destination = destination;
        this.trip_time = trip_time;
        time_map.put(destination,trip_time);
    }

    public String getDestination() {
        return destination;
    }

    public static Map<String, Double> getTime_map() {
        return time_map;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public double getTrip_time() {
        return trip_time;
    }

    public void setTrip_time(double trip_time) {
        this.trip_time = trip_time;
    }

    @Override
    public String toString() {
        return "Route{" +
                "destination='" + destination + '\'' +
                ", trip_time=" + trip_time +
                '}';
    }
}
