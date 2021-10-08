import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Display {

    private static JFormattedTextField nameField;
    private static JFormattedTextField emailField;
    private static JFormattedTextField phoneNumberField;
    private static JFormattedTextField genderField;
    private static JFormattedTextField ageField;
    private static JFormattedTextField destinationField;
    private static JFormattedTextField departureTimeField;

    public static void launchGui() {
        JFrame f = new JFrame("Ticket registration");

        f.setLayout(null);

        JLabel nameLabel = new JLabel("Name: ");
        JLabel emailLabel = new JLabel("Email: ");
        JLabel phoneNumberLabel = new JLabel("Phone Number: ");
        JLabel genderLabel = new JLabel("Gender: ");
        JLabel ageLabel = new JLabel("Age: ");
        JLabel destinationLabel = new JLabel("Destination: ");
        JLabel departureTimeLabel = new JLabel("Departure: ");


        nameField = new JFormattedTextField();
        emailField = new JFormattedTextField();
        phoneNumberField = new JFormattedTextField();
        genderField = new JFormattedTextField();
        ageField = new JFormattedTextField();
        destinationField = new JFormattedTextField();
        departureTimeField = new JFormattedTextField();

        int xLabel = 50;
        int xField = 200;

        int width = 100;
        int height = 20;

        int yStart = 50;
        int spacing = 30;

        nameLabel.setBounds(xLabel, yStart, width, height);
        nameField.setBounds(xField, yStart, width, height);
        f.add(nameLabel);
        f.add(nameField);

        emailLabel.setBounds(xLabel, yStart + spacing, width, height);
        emailField.setBounds(xField, yStart + spacing, width, height);
        f.add(emailLabel);
        f.add(emailField);

        phoneNumberLabel.setBounds(xLabel, yStart + (2 * spacing), width, height);
        phoneNumberField.setBounds(xField, yStart + (2 * spacing), width, height);
        phoneNumberField.setColumns(10);
        f.add(phoneNumberLabel);
        f.add(phoneNumberField);

        genderLabel.setBounds(xLabel, yStart + (3 * spacing), width, height);
        genderField.setBounds(xField, yStart + (3 * spacing), width, height);
        genderField.setColumns(10);
        f.add(genderLabel);
        f.add(genderField);

        ageLabel.setBounds(xLabel, yStart + (4 * spacing), width, height);
        ageField.setBounds(xField, yStart + (4 * spacing), width, height);
        ageField.setColumns(10);
        f.add(ageLabel);
        f.add(ageField);

        destinationLabel.setBounds(xLabel, yStart + (5 * spacing), width, height);
        destinationField.setBounds(xField, yStart + (5 * spacing), width, height);
        destinationField.setColumns(10);
        f.add(destinationLabel);
        f.add(destinationField);

        departureTimeLabel.setBounds(xLabel, yStart + (6 * spacing), width, height);
        departureTimeField.setBounds(xField, yStart + (6 * spacing), width, height);
        f.add(departureTimeLabel);
        f.add(departureTimeField);

        JButton b = new JButton("submit");
        b.setBounds(xField, yStart + (7 * spacing), width, (height*2));
        f.add(b);



//        b.addActionListener(new sentButtonClickedActionListener());

        f.setSize(400, 400);
        f.setVisible(true);
    }

    public static int parseAge(String age) {
        if (!age.equals("")) {
            return Integer.parseInt(age);
        }
        return 0;
    }

    static class sentButtonClickedActionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String name = nameField.getText();
            String email = emailField.getText();
            String phoneNumber = phoneNumberField.getText();
            String gender = genderField.getText();
            String age = ageField.getText();
            String destination = destinationField.getText();
            String departureTime = departureTimeField.getText();


            User u = new User(name, email, phoneNumber, gender, parseAge(age), destination, departureTime);
            System.out.println(u);
        }
    }
}
