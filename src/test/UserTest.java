import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    private User user;

    @BeforeEach
    void setUp() {
        user = new User("Bob", "bob@email.com",
                "555-555-5555", "m", 25,
                "Tokyo", "1:00" );
    }

    @Test
    void getName() {
        System.out.println(user.getName());
        assertEquals("Bob", user.getName(), "getName Failed");
    }

    @Test
    void getEmail() {
        System.out.println(user.getEmail());
        assertEquals("bob@email.com", user.getEmail(), "getEmail Failed");
    }

    @Test
    void getPhoneNumber() {
        System.out.println(user.getPhoneNumber());
        assertEquals("555-555-5555", user.getPhoneNumber(), "getPhoneNumber Failed");
    }

    @Test
    void getGender() {
        System.out.println(user.getGender());
        assertEquals("m", user.getGender(), "getGender Failed");
    }

    @Test
    void getAge() {
        System.out.println(user.getAge());
        assertEquals(25, user.getAge(), "getAge Failed");
    }

    @Test
    void getDestination() {
        System.out.println(user.getDestination());
        assertEquals("Tokyo", user.getDestination(), "getDestination Failed");
    }

    @Test
    void getDepartureTime() {
        System.out.println(user.getDepartureTime());
        assertEquals("1:00", user.getDepartureTime(), "getDepartureTime Failed");
    }
}