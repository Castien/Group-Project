public class Ticket {
    private final User user;
    private final String eta;
    private final double ticketPrice;
    private final int boardingPassNumber;

    private static int currentBoardingPassNumber = 100;

    public Ticket(User user, String eta, double ticketPrice) {
        this.user = user;
        this.eta = eta;
        this.ticketPrice = getTicketPrice();
        this.boardingPassNumber = getNewBoardingPassNumber();
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "user=" + user +
                ", eta='" + eta + '\'' +
                ", ticketPrice=" + ticketPrice +
                ", boardingPassNumber=" + boardingPassNumber +
                '}';
    }

    public User getUser() {
        return user;
    }

    public String getEta() {
        String departure = user.getDepartureTime();

        return eta;
    }

    public double getTicketPrice() {

        double price = 10d;
        int age = user.getAge();

        if(age <= 12){ price*=.5;}
        if(age >= 60){ price*=.4;}
        if(user.getGender().equals("f")){ price*=.75;}

        return price;
    }

    public int getBoardingPassNumber() {
        return boardingPassNumber;
    }

    public static int getCurrentBoardingPassNumber() {
        return currentBoardingPassNumber;
    }

    public int getNewBoardingPassNumber() {
        currentBoardingPassNumber++;
        return currentBoardingPassNumber;
    }
}
