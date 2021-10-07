import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * This class is for reading and writing tickets and stubs to files
 */
public class TicketProcessor {
    /**
     * This holds a map of the tickets in memory.
     * This map is used as an object that gets serialized to and from files.
     */
    private static Map<Integer, Ticket> tickets = new  HashMap<>();

    /**
     * This method serializes the tickets map to a file.
     */
    public static void writeTickets(){
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("src\\com\\company\\tickets.txt"))){
            oos.writeObject(tickets);
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    /**
     * This method reads the serialized map from a file and stores it in the tickets map instance variable.
     */
    @SuppressWarnings("unchecked")
    public static void readTickets() {
        try{
            try {
                ObjectInputStream ois = new ObjectInputStream(new FileInputStream("src\\com\\company\\tickets.txt"));
                Object obj = ois.readObject();
                if (obj instanceof Map) tickets = (HashMap<Integer, Ticket>) obj;

            } catch (EOFException ignored) {}
        }catch(IOException | ClassNotFoundException ignored){
            java.lang.System.out.println("Error reading users.");
        }
    }

    /**
     * this method is used to add tickets to the map and store them in files.
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
