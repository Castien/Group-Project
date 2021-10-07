public class Ticket {
    private User user;
    private String eta;
    private double ticketPrice;
    private final String boardingPassNumber;

    public Ticket(User user, String eta, double ticketPrice, String boardingPassNumber) {
        this.user = user;
        this.eta = eta;
        this.ticketPrice = ticketPrice;
        this.boardingPassNumber = boardingPassNumber;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getEta() {
        return eta;
    }

    public void setEta(String eta) {
        this.eta = eta;
    }

    public double getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(double ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    public String getBoardingPassNumber() {
        return boardingPassNumber;
    }
}
