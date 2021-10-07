import java.io.Serializable;

public class User implements Serializable {
    private String name;
    private String email;
    private String phoneNumber;
    private String gender;
    private int age;
    private String destination;
    private String departureTime;

    public User(String name, String email, String phoneNumber, String gender, int age, String destination, String departureTime) {
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
        this.age = age;
        this.destination = destination;
        this.departureTime = departureTime;
    }

    public User(){
        this("name", "email", "phoneNumber", "gender",
                0, "destination", "departureTime");
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }
}
