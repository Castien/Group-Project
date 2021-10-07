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
        firstName = scan.nextLine();
        System.out.println("Please enter your last name:");
        lastName = scan.nextLine();
        String name = firstName + " " + lastName;
        System.out.println("Please enter your email address:");
        String email = scan.nextLine();
        System.out.println("Please enter your phone number:");
        String phoneNumber = scan.nextLine();
        System.out.println("Please enter your gender:");
        String gender = scan.nextLine();
        System.out.println("Please enter your age:");
        int age = scan.nextInt();
        System.out.println("Please enter your destination:");
        String destination = scan.nextLine();
        System.out.println("Please enter your departure time:");
        String departureTime = scan.nextLine();

        User user = new User(name, email, phoneNumber, gender, age, destination, departureTime);
    }

    static void userMenu() {
        switch (getInput()) {
            case 1:
                //option 1 - apply new user pass
                applyUser();
                break;
            case 2:
                //option 2 - get existing pass
//                    printPass();
            case 3:
                //option 3 - exit
                System.out.println("Thank you!");
                System.exit(0);
                break;
            default:
                //any other input results in error and returns to beginning of the method
                System.out.println("Whoops! Something broke!");
                userMenu();
        }
    }
}