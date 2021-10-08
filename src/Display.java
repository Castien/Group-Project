import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Display{


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

        JFormattedTextField firstNameField = new JFormattedTextField();
        JFormattedTextField lastNameField = new JFormattedTextField();
        JFormattedTextField emailField = new JFormattedTextField();
        JFormattedTextField phoneNumberField = new JFormattedTextField();
        JFormattedTextField genderField = new JFormattedTextField();
        JFormattedTextField ageField = new JFormattedTextField();
        JFormattedTextField destinationField = new JFormattedTextField();
        JFormattedTextField departureTimeField = new JFormattedTextField();


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



        f.setSize(400,500);
        f.setVisible(true);
    }

    static class sentButtonClickedActionListener implements ActionListener {
        public void actionPerformed(ActionEvent e){
            System.out.println("click");
        }
    }
}
