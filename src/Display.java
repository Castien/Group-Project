import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Display {


    private static final boolean testFlag = true;

    private static JFrame f;

    private static JFormattedTextField nameField;
    private static JFormattedTextField emailField;
    private static JFormattedTextField phoneNumberField;
    private static JFormattedTextField genderField;
    private static JFormattedTextField ageField;
    private static JFormattedTextField destinationField;
    private static JFormattedTextField departureTimeField;

    public static void launchGui() {
        if(f != null) f.dispose();

        f = new JFrame("Ticket Registration");

        f.setLayout(null);

        JLabel nameLabel = new JLabel("Name: ", JLabel.RIGHT);
        JLabel emailLabel = new JLabel("Email: ", JLabel.RIGHT);
        JLabel phoneNumberLabel = new JLabel("Phone Number: ", JLabel.RIGHT);
        JLabel genderLabel = new JLabel("Gender: ", JLabel.RIGHT);
        JLabel ageLabel = new JLabel("Age: ", JLabel.RIGHT);
        JLabel destinationLabel = new JLabel("Destination: ", JLabel.RIGHT);
        JLabel departureTimeLabel = new JLabel("Departure: ", JLabel.RIGHT);


        if(testFlag){
            nameField = new JFormattedTextField("Name");
            emailField = new JFormattedTextField("puppy@hotmail.com");
            phoneNumberField = new JFormattedTextField("123-4567");
            genderField = new JFormattedTextField("male");
            ageField = new JFormattedTextField("27");
            destinationField = new JFormattedTextField("mars");
            departureTimeField = new JFormattedTextField();
        }else{
            nameField = new JFormattedTextField();
            emailField = new JFormattedTextField();
            phoneNumberField = new JFormattedTextField();
            genderField = new JFormattedTextField();
            ageField = new JFormattedTextField();
            destinationField = new JFormattedTextField();
            departureTimeField = new JFormattedTextField();
        }

        int width = 100;
        int height = 20;

        int xLabel = 20;
        int xField = width + xLabel + 10;

        int yStart = 20;
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
        f.add(phoneNumberLabel);
        f.add(phoneNumberField);

        genderLabel.setBounds(xLabel, yStart + (3 * spacing), width, height);
        genderField.setBounds(xField, yStart + (3 * spacing), width, height);
        f.add(genderLabel);
        f.add(genderField);

        ageLabel.setBounds(xLabel, yStart + (4 * spacing), width, height);
        ageField.setBounds(xField, yStart + (4 * spacing), width, height);
        f.add(ageLabel);
        f.add(ageField);

        destinationLabel.setBounds(xLabel, yStart + (5 * spacing), width, height);
        destinationField.setBounds(xField, yStart + (5 * spacing), width, height);
        f.add(destinationLabel);
        f.add(destinationField);

        departureTimeLabel.setBounds(xLabel, yStart + (6 * spacing), width, height);
        departureTimeField.setBounds(xField, yStart + (6 * spacing), width, height);
        f.add(departureTimeLabel);
        f.add(departureTimeField);

        JButton b = new JButton("submit");
        b.setBounds(xField, yStart + (7 * spacing), width, (height*2));
        f.add(b);

        b.addActionListener(new sentButtonClickedActionListener());

        f.setSize((width * 3), ((height + spacing) * 7));
        f.setVisible(true);
    }

    public static void launchSecondGui(Ticket t) {

        User u = t.getUser();

        f.dispose();
        f = new JFrame("Ticket Information");

        f.setLayout(null);

        JLabel boardingPassNumberLabel = new JLabel("Boarding Pass Number: ", JLabel.RIGHT);
        JLabel etaLabel = new JLabel("ETA: ", JLabel.RIGHT);
        JLabel ticketPriceLabel = new JLabel("Ticket Price: ", JLabel.RIGHT);

        JLabel nameLabel = new JLabel("Name: ", JLabel.RIGHT);
        JLabel emailLabel = new JLabel("Email: ", JLabel.RIGHT);
        JLabel phoneNumberLabel = new JLabel("Phone Number: ", JLabel.RIGHT);
        JLabel genderLabel = new JLabel("Gender: ", JLabel.RIGHT);
        JLabel ageLabel = new JLabel("Age: ", JLabel.RIGHT);
        JLabel destinationLabel = new JLabel("Destination: ", JLabel.RIGHT);
        JLabel departureTimeLabel = new JLabel("Departure: ", JLabel.RIGHT);

        JLabel boardingPassNumberInfoLabel = new JLabel(t.getBoardingPassNumber() + "", JLabel.LEFT);
        JLabel etaInfoLabel = new JLabel(t.getEta(), JLabel.LEFT);
        JLabel ticketPriceInfoLabel = new JLabel(t.getTicketPrice() + "", JLabel.LEFT);

        JLabel nameInfoLabel = new JLabel(u.getName(), JLabel.LEFT);
        JLabel emailInfoLabel = new JLabel(u.getEmail(), JLabel.LEFT);
        JLabel phoneNumberInfoLabel = new JLabel(u.getPhoneNumber(), JLabel.LEFT);
        JLabel genderInfoLabel = new JLabel(u.getGender(), JLabel.LEFT);
        JLabel ageInfoLabel = new JLabel(u.getAge() + "", JLabel.LEFT);
        JLabel destinationInfoLabel = new JLabel(u.getDestination(), JLabel.LEFT);
        JLabel departureTimeInfoLabel = new JLabel(u.getDepartureTime(), JLabel.LEFT);


        int width = 200;
        int height = 20;

        int xLabel = 20;
        int xField = width + xLabel + 10;

        int yStart = 20;
        int spacing = 30;


        boardingPassNumberLabel.setBounds(xLabel, yStart, width, height);
        boardingPassNumberInfoLabel.setBounds(xField, yStart, width, height);
        f.add(boardingPassNumberLabel);
        f.add(boardingPassNumberInfoLabel);

        etaLabel.setBounds(xLabel, yStart + spacing, width, height);
        etaInfoLabel.setBounds(xField, yStart + spacing, width, height);
        f.add(etaLabel);
        f.add(etaInfoLabel);

        ticketPriceLabel.setBounds(xLabel, yStart + (2 * spacing), width, height);
        ticketPriceInfoLabel.setBounds(xField, yStart + (2 * spacing), width, height);
        f.add(ticketPriceLabel);
        f.add(ticketPriceInfoLabel);

        nameLabel.setBounds(xLabel, yStart + (3 * spacing), width, height);
        nameInfoLabel.setBounds(xField, yStart + (3 * spacing), width, height);
        f.add(nameLabel);
        f.add(nameInfoLabel);

        emailLabel.setBounds(xLabel, yStart + (4 * spacing), width, height);
        emailInfoLabel.setBounds(xField, yStart + (4 * spacing), width, height);
        f.add(emailLabel);
        f.add(emailInfoLabel);

        phoneNumberLabel.setBounds(xLabel, yStart + (5 * spacing), width, height);
        phoneNumberInfoLabel.setBounds(xField, yStart + (5 * spacing), width, height);
        f.add(phoneNumberLabel);
        f.add(phoneNumberInfoLabel);

        genderLabel.setBounds(xLabel, yStart + (6 * spacing), width, height);
        genderInfoLabel.setBounds(xField, yStart + (6 * spacing), width, height);
        f.add(genderLabel);
        f.add(genderInfoLabel);

        ageLabel.setBounds(xLabel, yStart + (7 * spacing), width, height);
        ageInfoLabel.setBounds(xField, yStart + (7 * spacing), width, height);
        f.add(ageLabel);
        f.add(ageInfoLabel);

        destinationLabel.setBounds(xLabel, yStart + (8 * spacing), width, height);
        destinationInfoLabel.setBounds(xField, yStart + (8 * spacing), width, height);
        f.add(destinationLabel);
        f.add(destinationInfoLabel);

        departureTimeLabel.setBounds(xLabel, yStart + (9 * spacing), width, height);
        departureTimeInfoLabel.setBounds(xField, yStart + (9 * spacing), width, height);
        f.add(departureTimeLabel);
        f.add(departureTimeInfoLabel);

        JButton b = new JButton("submit");
        b.setBounds(width, yStart + (10 * spacing), width, (height*2));
        f.add(b);

        b.addActionListener(new okButtonClickedActionListener());

        f.setSize((width * 3), ((height + spacing) * 9));
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
            Ticket t = new Ticket(u);
            launchSecondGui(t);
        }
    }

    static class okButtonClickedActionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            launchGui();
        }
    }
}
