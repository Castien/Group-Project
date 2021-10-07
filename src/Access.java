import java.util.Scanner;

public class Access {

    static Scanner scan = new Scanner(System.in);

    //initializes option to zero, takes user input for Menus
    public static int getInput() {
        int num = 0;
        try {
            num = Integer.parseInt(scan.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Not a valid entry. Please enter valid numbers.");
        }
        return num;
    }

    public static String getStringInput() {
        String input = "";
        do {
            try {
                input = scan.nextLine();
            } catch (NumberFormatException e) {
                System.out.println("Not a valid entry. Alphanumeric characters only.");
            }
        } while (!input.matches("[a-zA-Z0-9]+"));
        return input;
    }

    public static void applyUser() {
        String firstName;
        String lastName;

        System.out.println("Please enter your first name:");
        firstName = getStringInput();
        System.out.println("Please enter your last name:");
        lastName = getStringInput();
        String name = firstName + " " + lastName;
        System.out.println("Please enter your email address:");
        String email = getStringInput();
        System.out.println("Please enter your phone number:");
        String phoneNumber = getStringInput();
        System.out.println("Please enter your gender:");
        String gender = getStringInput();
        System.out.println("Please enter your age:");
        int age = getInput();
        System.out.println("Please enter your destination:");
        String destination = getStringInput();
        System.out.println("Please enter your departure time:");
        String departureTime = getStringInput();

        User user = new User(name, email, phoneNumber, gender, age, destination, departureTime);
    }

}
