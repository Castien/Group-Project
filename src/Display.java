import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.ArrayList;

import static java.lang.String.format;

public class Display {

    private static JFrame f;

    private static JFormattedTextField nameField;
    private static JFormattedTextField emailField;
    private static JFormattedTextField phoneNumberField;

    private static JRadioButton genderMaleButton;
    private static JRadioButton genderFemaleButton;

    private static JSpinner ageSpinner;

    private static JComboBox<String> destinationField;
    private static JComboBox<String> departureTimeField;

    private static JLabel errorLabel;

    private static final String REGEX_FOR_PHONE = "^(\\+\\d{1,2}\\s)?\\(?\\d{3}\\)?[\\s.-]?\\d{3}[\\s.-]?\\d{4}$";

    private static final String REGEX_FOR_EMAIL = "(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)" +
            "*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x" +
            "7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:(2(5[0-5]|[0" +
            "-4][0-9])|1[0-9][0-9]|[1-9]?[0-9]))\\.){3}(?:(2(5[0-5]|[0-4][0-9])|1[0-9][0-9]|[1-9]?[0-9])|[a-z0-9-]*[a" +
            "-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f" +
            "])+)\\])";

    private static ArrayList<Route> routes;

    public static void launchGui() {
        establishConnection();

        if (f != null) f.dispose();

        f = new JFrame("Ticket Registration");

        f.setLayout(null);


        String[] data;

        if(true){
            //prefill data with strings for testing
            data = new String[]{"Name", "puppy@hotmail.com", "123-456-7890"};
        }else{
            //leave data empty
            data = new String[]{"","",""};
        }

        nameField = new JFormattedTextField(data[0]);
        emailField = new JFormattedTextField(data[1]);
        phoneNumberField = new JFormattedTextField(data[2]);

        String[] destinations = new String[routes.size()];
        for(int i=0; i<routes.size(); i++){
            destinations[i] = routes.get(i).getDestination();
        }

        destinationField = new JComboBox<>(destinations);

        final int NUM_TIMES = 24;
        String[] departureTimes = new String[NUM_TIMES];
        for(int i=0; i<NUM_TIMES; i++){
            departureTimes[i] = format("%2d:00", i);
        }

        departureTimeField = new JComboBox<>(departureTimes);

        genderMaleButton = new JRadioButton("m");
        genderFemaleButton = new JRadioButton("f");
        JRadioButton genderOtherButton = new JRadioButton("na");

        ageSpinner = new JSpinner();

        errorLabel = new JLabel("", JLabel.RIGHT);

        int border = 20;
        int gap = 10;

        int width = 125;

        int x2 = width + border + gap;

        int spacing = border + gap;

        String[] labelText = {"Name: ", "Email: ", "Phone Number: ",
                "Gender: ", "Age: ", "Destination: ", "Departure Time: "};

        for (int i = 0; i < labelText.length; i++) {
            addLabelToFrame(labelText[i], spacing, border, border, width, border, i);
        }

        width += 75;

        nameField.setBounds(x2, border, width, border);
        f.add(nameField);

        emailField.setBounds(x2, border + spacing, width, border);
        f.add(emailField);

        phoneNumberField.setBounds(x2, border + (2 * spacing), width, border);
        f.add(phoneNumberField);

        ButtonGroup bg = new ButtonGroup();

        genderMaleButton.setBounds(x2, border + (3 * spacing), width/4, border);
        bg.add(genderMaleButton);
        f.add(genderMaleButton);

        genderFemaleButton.setBounds(x2 + 50, border + (3 * spacing), width/4, border);
        bg.add(genderFemaleButton);
        f.add(genderFemaleButton);

        genderOtherButton.setBounds(x2 + 100, border + (3 * spacing), width/4, border);
        bg.add(genderOtherButton);
        f.add(genderOtherButton);

        ageSpinner.setBounds(x2, border + (4 * spacing), width/4, border);
        f.add(ageSpinner);

        destinationField.setBounds(x2, border + (5 * spacing), width, border);
        f.add(destinationField);

        departureTimeField.setBounds(x2, border + (6 * spacing), width, border);
        f.add(departureTimeField);

        JButton b = new JButton("submit");
        b.setBounds(x2, border + (labelText.length * spacing), width, (border * 2));
        b.addActionListener(new sentButtonClickedActionListener());
        f.add(b);

        errorLabel.setBounds(x2, border + ((labelText.length + 2) * spacing), width, border);
        f.add(errorLabel);

        f.setSize((width * 2), ((border + spacing) * labelText.length));
        f.setVisible(true);
    }

    public static void launchSecondGui(Ticket t) {

        User u = t.getUser();

        f.dispose();
        f = new JFrame("Ticket Information");

        f.setLayout(null);

        int spacing = 30;
        int width = 200;
        int height = 20;

        int x = 0;
        int y = 20;

        String[] labelText = {"Boarding Pass Number: ", "Destination: ", "Departure Time: ", "ETA: ", "Ticket Price: ",
                "Name: ", "Email: ", "Phone Number: ", "Gender: ", "Age: "};

        String[] infoText = {t.getBoardingPassNumber() + "",
                u.getDestination(), u.getDepartureTime(), t.getEta(), t.getTicketPrice() + "",
                u.getName(), u.getEmail(), u.getPhoneNumber(), u.getGender(), u.getAge() + ""};

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

    private static void establishConnection(){

        Connection conn = null;
        try {
            conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/boarding_pass","root","root");
            if (conn != null) {
                Statement statement = conn.createStatement();
                ResultSet results = statement.executeQuery("SELECT destination FROM boarding_pass.route");

                ArrayList<String> destinations = new ArrayList<>();
                while(results.next()){
                    destinations.add(results.getString(1));
                }

                results = statement.executeQuery("SELECT trip_time FROM boarding_pass.route");

                ArrayList<String> times = new ArrayList<>();
                while(results.next()){
                    times.add(results.getString(1));
                }

                routes = new ArrayList<>();
                if(destinations.size() == times.size()){
                    for (int i=0; i< destinations.size(); i++){
                        routes.add(new Route(destinations.get(i), Double.parseDouble(times.get(i))));
                    }
                }
                routes.forEach(System.out::println);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (conn != null && !conn.isClosed()) {
                    conn.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    private static class sentButtonClickedActionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String name = nameField.getText();
            String email = emailField.getText();
            String phoneNumber = phoneNumberField.getText();

            String gender = "other";
            if(genderMaleButton.isSelected()){
                gender = "male";
            }else if(genderFemaleButton.isSelected()){
                gender = "female";
            }

            int age = parseAge(ageSpinner.getValue() + "");
            String destination = destinationField.getSelectedItem() + "";
            String departureTime = departureTimeField.getSelectedItem() + "";

            if(!email.matches(REGEX_FOR_EMAIL)){
                errorLabel.setText("Please enter a valid email.");
            }else if(!phoneNumber.matches(REGEX_FOR_PHONE)){
                errorLabel.setText("Please enter a valid phone number.");
            }else if(age < 0 || age >= 150){
                errorLabel.setText("Enter a valid age.");
            }else{
                User u = new User(name, email, phoneNumber, gender, age, destination, departureTime);
                Ticket t = new Ticket(u);
                launchSecondGui(t);
            }
        }
    }

    private static class okButtonClickedActionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            launchGui();
        }
    }
}
