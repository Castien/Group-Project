import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TicketTest {

    private User user;
    private Ticket ticket;

    @BeforeEach
    void setUp() {
        user = new User("Bob", "bob@email.com",
                "555-555-5555", "m", 25,
                "Tokyo", "1:00" );
        ticket = new Ticket("2:00", 10.00, 101, user);
    }

    @Test
    void getEta() {
        System.out.println(ticket.getEta());
        assertEquals("2:00", ticket.getEta(), "getEta Failed");
    }

    @Test
    void getTicketPrice() {
        System.out.println(ticket.getTicketPrice());
        assertEquals(10.00, ticket.getTicketPrice(), "getTicketPrice Failed");
    }

    @Test
    void getBoardingPassNumber() {
        System.out.println(ticket.getBoardingPassNumber());
        assertEquals(101, ticket.getBoardingPassNumber(), "getBoardingPassNumber Failed");
    }
}