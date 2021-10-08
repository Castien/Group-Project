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
        if (f != null) f.dispose();

        f = new JFrame("Ticket Registration");

        f.setLayout(null);

        JLabel nameLabel = new JLabel("Name: ", JLabel.RIGHT);
        JLabel emailLabel = new JLabel("Email: ", JLabel.RIGHT);
        JLabel phoneNumberLabel = new JLabel("Phone Number: ", JLabel.RIGHT);
        JLabel genderLabel = new JLabel("Gender: ", JLabel.RIGHT);
        JLabel ageLabel = new JLabel("Age: ", JLabel.RIGHT);
        JLabel destinationLabel = new JLabel("Destination: ", JLabel.RIGHT);
        JLabel departureTimeLabel = new JLabel("Departure: ", JLabel.RIGHT);

        if (testFlag) {
            nameField = new JFormattedTextField("Name");
            emailField = new JFormattedTextField("puppy@hotmail.com");
            phoneNumberField = new JFormattedTextField("123-4567");
            genderField = new JFormattedTextField("male");
            ageField = new JFormattedTextField("27");
            destinationField = new JFormattedTextField("mars");
            departureTimeField = new JFormattedTextField();
        } else {
            nameField = new JFormattedTextField();
            emailField = new JFormattedTextField();
            phoneNumberField = new JFormattedTextField();
            genderField = new JFormattedTextField();
            ageField = new JFormattedTextField();
            destinationField = new JFormattedTextField();
            departureTimeField = new JFormattedTextField();

        }


        JRadioButton genderButton = new JRadioButton();

        int border = 20;
        int gap = 10;

        int width = 125;
        int height = border;

        int x1 = border;
        int x2 = width + x1 + gap;

        int y = border;
        int spacing = border + gap;

        String[] labelText = {"Name: ", "Email: ", "Phone Number: ",
                "Gender: ", "Age: ", "Destination: ", "Departure Time: "};

        for (int i = 0; i < labelText.length; i++) {
            addLabelToFrame(labelText[i], spacing, x1, y, width, height, i);
        }

        width += 75;

        nameField.setBounds(x2, y, width, height);
        f.add(nameField);

        emailField.setBounds(x2, y + spacing, width, height);
        f.add(emailField);

        phoneNumberField.setBounds(x2, y + (2 * spacing), width, height);
        f.add(phoneNumberField);

        genderField.setBounds(x2, y + (3 * spacing), width, height);
        f.add(genderField);

        ageField.setBounds(x2, y + (4 * spacing), width, height);
        f.add(ageField);

        destinationField.setBounds(x2, y + (5 * spacing), width, height);
        f.add(destinationField);

        departureTimeField.setBounds(x2, y + (6 * spacing), width, height);
        f.add(departureTimeField);

        JButton b = new JButton("submit");
        b.setBounds(x2, y + (labelText.length * spacing), width, (height * 2));
        f.add(b);

        b.addActionListener(new sentButtonClickedActionListener());

        f.setSize((width * 2), ((height + spacing) * labelText.length));
        f.setVisible(true);
    }

    public static void launchSecondGui(Ticket t) {

        User u = t.getUser();

        f.dispose();
        f = new JFrame("Ticket Information");

        f.setLayout(null);

        int width = 200;
        int height = 20;

        int x = 0;

        int y = 20;
        int spacing = 30;

        String[] labelText = {"Boarding Pass Number: ", "ETA: ", "Ticket Price: ",
                "Name: ", "Email: ", "Phone Number: ", "Gender: ", "Age: ", "Destination: ", "Departure Time: "};

        String[] infoText = {t.getBoardingPassNumber() + "", t.getEta(), t.getTicketPrice() + "",
                u.getName(), u.getEmail(), u.getPhoneNumber(), u.getGender(), u.getAge() + "", u.getDestination(),
                u.getDepartureTime()};

        for (int i = 0; i < labelText.length; i++) {
            addLabelAndInfoToFrame(labelText[i], infoText[i], spacing, x, y, width, height, i);
        }

        JButton b = new JButton("submit");
        b.setBounds((width / 2) - 10, y + (labelText.length * spacing), width, (height * 2));
        f.add(b);

        b.addActionListener(new okButtonClickedActionListener());

        f.setSize((width * 2), ((height + spacing) * (labelText.length - 1)));
        f.setVisible(true);
    }

    private static void addLabelToFrame(String labelString,
                                        int spacing, int x, int y, int width, int height, int index) {

        JLabel label = new JLabel(labelString, JLabel.RIGHT);
        label.setBounds(x, y + (index * spacing), width - 10, height);
        f.add(label);
    }


    private static void addLabelAndInfoToFrame(String labelString, String infoString,
                                               int spacing, int x, int y, int width, int height, int index) {

        JLabel label = new JLabel(labelString, JLabel.RIGHT);
        JLabel info = new JLabel(infoString, JLabel.LEFT);

        label.setBounds(x, y + (index * spacing), width - 10, height);
        info.setBounds(width + x, y + (index * spacing), width, height);
        f.add(label);
        f.add(info);
    }

    private static int parseAge(String age) {
        if (!age.equals("")) {
            return Integer.parseInt(age);
        }
        return 0;
    }

    private static class sentButtonClickedActionListener implements ActionListener {
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

    private static class okButtonClickedActionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            launchGui();
        }
    }
}
