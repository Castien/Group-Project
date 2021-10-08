import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Display{

    private static JFormattedTextField firstNameField;
    private static JFormattedTextField lastNameField;
    private static JFormattedTextField emailField;
    private static JFormattedTextField phoneNumberField;
    private static JFormattedTextField genderField;
    private static JFormattedTextField ageField;
    private static JFormattedTextField destinationField;
    private static JFormattedTextField departureTimeField;

    static void printUserMenu() {
        System.out.println("*********************************************");
        System.out.println("To apply for a Boarding Pass, press 1:");
//        System.out.println("To print an existing Boarding Pass, press 2: ");
        System.out.println("To exit, press 3: ");
        System.out.println("*********************************************");
        Access.userMenu();
    }

    public static void gui(){
        JFrame f = new JFrame();

        JPanel gridPane = new JPanel();
        
        GridLayout gridLayout = new GridLayout(0,2);
        gridPane.setLayout(gridLayout);

        JLabel firstNameLabel = new JLabel("First Name: ");
        JLabel lastNameLabel = new JLabel("Last Name: ");
        JLabel emailLabel = new JLabel("Email: ");
        JLabel phoneNumberLabel = new JLabel("Phone Number: ");
        JLabel genderLabel = new JLabel("Gender: ");
        JLabel ageLabel = new JLabel("Age: ");
        JLabel destinationLabel = new JLabel("Destination: ");
        JLabel departureTimeLabel = new JLabel("Departure: ");

        JButton b=new JButton("submit");

        firstNameField = new JFormattedTextField();
        lastNameField = new JFormattedTextField();
        emailField = new JFormattedTextField();
        phoneNumberField = new JFormattedTextField();
        genderField = new JFormattedTextField();
        ageField = new JFormattedTextField();
        destinationField = new JFormattedTextField();
        departureTimeField = new JFormattedTextField();


        gridPane.add(firstNameLabel);
        gridPane.add(firstNameField);

        gridPane.add(lastNameLabel);
        gridPane.add(lastNameField);

        gridPane.add(emailLabel);
        gridPane.add(emailField);

        gridPane.add(phoneNumberLabel);
        gridPane.add(phoneNumberField);

        gridPane.add(genderLabel);
        gridPane.add(genderField);

        gridPane.add(ageLabel);
        gridPane.add(ageField);

        gridPane.add(destinationLabel);
        gridPane.add(destinationField);

        gridPane.add(departureTimeLabel);
        gridPane.add(departureTimeField);

        gridPane.add(b);

        b.addActionListener(new sentButtonClickedActionListener());

        gridPane.setBounds(50, 50, 300, 400);

        gridLayout.setVgap(20);

        f.add(gridPane);



        f.setSize(600,500);
        f.setVisible(true);
    }

    public static int parseAge(String age){
        if(!age.equals("")){
            return Integer.parseInt(age);
        } return 0;
    }

    static class sentButtonClickedActionListener implements ActionListener {
        public void actionPerformed(ActionEvent e){
            String firstName = firstNameField.getText();
            String lastName = lastNameField.getText();
            String email = emailField.getText();
            String phoneNumber = phoneNumberField.getText();
            String gender = genderField.getText();
            String age = ageField.getText();
            String destination = destinationField.getText();
            String departureTime = departureTimeField.getText();

            String name = firstName + " " + lastName;

            User u = new User(name, email, phoneNumber, gender, parseAge(age), destination, departureTime);
            System.out.println(u);
        }
    }
}
