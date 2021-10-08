import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * This class is for reading and writing tickets and ticketStubs to files
 */
public class TicketProcessor {
    /**
     * This holds a map of the tickets in memory
     * This map is also used as an object that gets serialized to and from files
     */
    private static Map<Integer, Ticket> tickets = new  HashMap<>();

    /**
     * prints out every ticket stored in the file
     */
    public static void printTickets(){
        readTickets();
        for(Ticket t : tickets.values()){
            System.out.println(t);
        }
    }

    /**
     * This method serializes the tickets map to a file
     */
    public static void writeTickets(){
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("src\\tickets.txt"))){
            oos.writeObject(tickets);
        }catch(IOException e){
            System.out.println("Failed to write tickets");
        }
    }

    public static void writeTicketStub(Ticket t){
        String ticketStubName = "src\\ticket-" + t.getBoardingPassNumber() + ".txt";
        try(FileWriter fw = new FileWriter(new File(ticketStubName))){
            fw.write(t.toString());
        }catch(IOException e){
            System.out.println("Failed to print ticket stub");
        }
    }

    /**
     * This method reads the serialized map from a file and stores it in the tickets map instance variable
     */
    @SuppressWarnings("unchecked")
    public static void readTickets() {
        try{
            try {
                ObjectInputStream ois = new ObjectInputStream(new FileInputStream("src\\tickets.txt"));
                Object obj = ois.readObject();
                if (obj instanceof HashMap) tickets = (HashMap<Integer, Ticket>) obj;
            } catch (EOFException ignored) {}
        }catch(IOException | ClassNotFoundException ignored){
            System.out.println("Failed to read tickets");
        }
    }

    /**
     * this method is used to add tickets to the map and store them in files
     * @param t is the ticket to be stored
     */
    public static void addTicket(Ticket t){
        tickets.put(t.getBoardingPassNumber(), t);
        writeTickets();
    }

    public static Map<Integer, Ticket> getTickets() {
        return tickets;
    }
}
