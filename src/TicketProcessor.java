import java.io.*;
import java.util.HashMap;

public class TicketProcessor {
    private static HashMap<String, User> tickets = new  HashMap<>();

    public static void writeUsers(){
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("src\\com\\company\\tickets.txt"))){
            oos.writeObject(tickets);
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    public static void readUsers() {
        try{
            try {
                ObjectInputStream ois = new ObjectInputStream(new FileInputStream("src\\com\\company\\tickets.txt"));
                Object obj = ois.readObject();
                if (obj instanceof HashMap) tickets = (HashMap<String, User>) obj;

            } catch (EOFException ignored) {}
        }catch(IOException | ClassNotFoundException ignored){
            java.lang.System.out.println("Error reading users.");
        }
    }

    public static HashMap<String, User> getTickets() {
        return tickets;
    }
}
