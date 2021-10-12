public class Main {

    /**
     * Main method for the BoardingPassTicket group project.
     * This program launches a gui with a form the user can fill out to create a train ticket.
     * Once the information is filled a ticket will be generated and displayed to the user.
     * A ticket stub file will be generated that can be printed and is also stored in a database.
     * The information regarding the trains is pulled from a database on a local mysql server.
     * Collaborators: Zachary Snyder and Eileen Lowers
     * @param args main args
     */
    public static void main(String[] args) {
        Connect.establishConnection();
        Display.launchGui();
    }
}
