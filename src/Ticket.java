import java.io.Serializable;
import java.text.SimpleDateFormat;

public class Ticket implements Serializable {

    /**
     * a unique identifier for the ticket
     */
    private final int boardingPassNumber;
    /**
     * a timestamp of the estimated arrival time
     */
    private final String eta;
    /**
     * the calculated cost of the ticket for the user
     */
    private final double ticketPrice;
    /**
     * stores information input by the user
     */
    private final User user;
    /**
     * a number that is used to set boardingPassNumber
     * this ensures there will never be duplicates
     */
    private static int currentBoardingPassNumber = 100;

    /**
     * The full constructor for the ticket class.
     *
     * @param user               the user requesting a ticket
     * @param eta                the estimated time of arrival
     * @param ticketPrice        the price the user will pay for the ticket
     * @param boardingPassNumber the unique identifier for the ticket
     */
    public Ticket(String eta, double ticketPrice, int boardingPassNumber, User user) {
        this.eta = eta;
        this.ticketPrice = ticketPrice;
        this.boardingPassNumber = boardingPassNumber;
        this.user = user;
    }

    /**
     * The preferred constructor for the Ticket class
     * Fills the unspecified fields with the getNew methods
     * @param user the user requesting a ticket
     */
    public Ticket(User user) {
        this.user = user;
        eta = getNewEta();
        ticketPrice = getNewTicketPrice();
        boardingPassNumber = getNewBoardingPassNumber();
        TicketProcessor.addTicket(this);
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "boardingPassNumber=" + boardingPassNumber +
                ", eta='" + eta + '\'' +
                ", ticketPrice=" + ticketPrice +
                ", user=" + user +
                '}';
    }

    /**
     * generates a new eta
     * @return a new eta
     */
    private String getNewEta() {
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return f.format(System.currentTimeMillis());
    }

    /**
     * calculates the price for a new ticket
     * @return the price for a new ticket
     */
    private double getNewTicketPrice() {

        double price = 10d;
        int age = user.getAge();

        if (age <= 12) {
            price *= .5;
        }
        if (age >= 60) {
            price *= .4;
        }
        if (user.getGender().equals("f")) {
            price *= .75;
        }

        return price;
    }

    /**
     * calls for TicketProcessor to read the ticket file and returns 1 more than the previous boardingPassNumber
     * @return a new boardingPassNumber valued 1 more than the last
     */
    private int getNewBoardingPassNumber() {
        TicketProcessor.readTickets();
        while(TicketProcessor.getTickets().containsKey(currentBoardingPassNumber)) currentBoardingPassNumber++;

        return currentBoardingPassNumber;
    }

    public User getUser() {return user;}

    public String getEta() {return eta;}

    public int getBoardingPassNumber() {return boardingPassNumber;}

    public static int getCurrentBoardingPassNumber() {return currentBoardingPassNumber;}
}
