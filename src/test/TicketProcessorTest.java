import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TicketProcessorTest {

    static Ticket t;

    @BeforeAll
    static void startSetUp() {
        Connect.readInfo();
    }

    @BeforeEach
    void setUp() {
        t = new Ticket(new User());
        TicketProcessor.addTicket(t);
    }

    @Test
    void getTickets() {
        assertNotEquals(TicketProcessor.getTickets(), null);
    }

    @Test
    void addTicket() {
        int size = TicketProcessor.getTickets().size();
        TicketProcessor.addTicket(new Ticket(new User()));
        assertNotEquals(size, TicketProcessor.getTickets().entrySet().size(), "addTicket failed");
    }

    @Test
    void printTickets() {
        TicketProcessor.printTickets();
    }

    @Test
    void writeTicketStub() {
        TicketProcessor.writeTicketStub(t);
    }

    @Test
    void writeTickets() {
        TicketProcessor.writeTickets();
    }

    @Test
    void readTickets() {
        TicketProcessor.readTickets();
    }




}