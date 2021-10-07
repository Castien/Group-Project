public class Main {

    /**
     * Main method for the BoardingPassTicket group project.
     * Collaborators: Zachary Snyder and Eileen Lowers
     * @param args main args
     */
    public static void main(String[] args) {

//        Display.printUserMenu();
        testTicket();
    }

    private static void testUser(){

    }

    private static void testTicket(){
        User u = new User();
        Ticket t = new Ticket(u);
        Ticket t1 = new Ticket(u);

        TicketProcessor.printTickets();
        TicketProcessor.writeTicketStub(t);
    }
}
