import java.io.Serializable;
import java.text.SimpleDateFormat;

/**
 * a POJO for user information.
 */
public class User implements Serializable{
    private final String name;
    private final String email;
    private final String phoneNumber;
    private final String gender;
    private final int age;
    private final String destination;
    private final String departureTime;

    /**
     * full and preferred constructor for the user class
     * @param name name of the user
     * @param email email for the user
     * @param phoneNumber phone number for the user
     * @param gender gender of the user
     * @param age age of the user
     * @param destination destination the user is trying to reach
     * @param departureTime the time it will take then to reach the destination
     */
    public User(String name, String email, String phoneNumber, String gender, int age, String destination, String departureTime) {
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
        this.age = age;
        this.destination = destination;
        this.departureTime = departureTime;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", gender='" + gender + '\'' +
                ", age=" + age +
                ", destination='" + destination + '\'' +
                ", departureTime='" + departureTime + '\'' +
                '}';
    }

    public String getName() {return name; }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getGender() {
        return gender;
    }

    public int getAge() {
        return age;
    }

    public String getDestination() {
        return destination;
    }

    public String getDepartureTime() {
        return departureTime;
    }
}
