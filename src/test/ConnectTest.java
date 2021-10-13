import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ConnectTest {

    @Test
    void readInfo() {
        Connect.readInfo();
        assertFalse(Connect.getRoutes().isEmpty(), "readInfo failed");
    }

    @Test
    void saveTicket() {
        assertNotEquals((double) Connect.saveTicket(new User(), "00:30", 10), null, "saveTicket failed");
    }
}