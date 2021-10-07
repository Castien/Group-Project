import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class TicketProcessor {
    private static Map<Integer, Ticket> tickets = new  HashMap<>();

    public static void writeTickets(){
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("src\\com\\company\\tickets.txt"))){
            oos.writeObject(tickets);
        }catch(IOException e){
            e.printStackTrace();
        }
    }

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

    public static void addTicket(Ticket t){
        tickets.put(t.getBoardingPassNumber(), t);
        writeTickets();


    }

    public static Map<Integer, Ticket> getTickets() {
        return tickets;
    }
}
