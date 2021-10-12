import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.ArrayList;
import java.util.Locale;

import static java.lang.String.format;

public class Display {

    /**
     * frame to display components with
     */
    private static JFrame f;

    /**
     * the text field that stores user input for the name. Cannot be blank.
     */
    private static JFormattedTextField nameField;
    /**
     * the text field that stores user input for the email. must follow the REGEX_FOR_EMAIL pattern.
     */
    private static JFormattedTextField emailField;
    /**
     * the text field that stores user input for the phone number. must follow the REGEX_FOR_PHONE pattern.
     */
    private static JFormattedTextField phoneNumberField;

    /**
     * button grouped with the other gender buttons that sets gender to "male" when selected.
     * If no button in the button group is selected, gender is set to "n/a"
     */
    private static JRadioButton genderMaleButton;
    /**
     * button grouped with the other gender buttons that sets gender to "female" when selected.
     * If no button in the button group is selected, gender is set to "n/a"
     */
    private static JRadioButton genderFemaleButton;
    /**
     * button grouped with the other gender buttons that sets gender to "other" when selected.
     * If no button in the button group is selected, gender is set to "n/a"
     */
    private static JRadioButton genderOtherButton;

    /**
     * spinner for the age of the user. Cannot be blank or contain a letter
     */
    private static JSpinner ageSpinner;

    /**
     * combo box that contains the destinations pulled in from the database.
     */
    private static JComboBox<String> destinationField;
    /**
     * combo box that contains information about the time required to reach a certain destination.
     * Also pulled from the database.
     */
    private static JComboBox<String> departureTimeField;

    /**
     * error label starts blank and gets overwritten whenever an error occurs to tell the user what they did wrong.
     */
    private static JLabel errorLabel;

    /**
     * regex expression that matches any valid phone number
     */
    private static final String REGEX_FOR_PHONE = "^(\\+\\d{1,2}\\s)?\\(?\\d{3}\\)?[\\s.-]?\\d{3}[\\s.-]?\\d{4}$";

    /**
     * regular expression that matches any valid email.
     * Doesn't like capital letters so strings must be toLower.
     */
    private static final String REGEX_FOR_EMAIL = "(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)" +
            "*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x" +
            "7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:(2(5[0-5]|[0" +
            "-4][0-9])|1[0-9][0-9]|[1-9]?[0-9]))\\.){3}(?:(2(5[0-5]|[0-4][0-9])|1[0-9][0-9]|[1-9]?[0-9])|[a-z0-9-]*[a" +
            "-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f" +
            "])+)\\])";

    /**
     * this method launches the first gui window that allows the user to fill out a form.
     * That form is used to create a ticket for the user.
     * Continues on to the launchSecondGui method.
     */
    public static void launchGui() {

        if (f != null) f.dispose();

        f = new JFrame("Ticket Registration");

        f.setLayout(null);

        String[] destinations = new String[Connect.getRoutes().size()];
        {
            int i = 0;
            for (String d : Connect.getRoutes().keySet()) {
                destinations[i] = d;
                i++;
            }
        }

        final int NUM_TIMES = 24;
        String[] departureTimes = new String[NUM_TIMES];
        for(int i=0; i<NUM_TIMES; i++){
            departureTimes[i] = format("%2d:00", i);
        }

        nameField = new JFormattedTextField("Name");
        emailField = new JFormattedTextField("puppy@hotmail.com");
        phoneNumberField = new JFormattedTextField("123-456-7890");
        destinationField = new JComboBox<>(destinations);
        departureTimeField = new JComboBox<>(departureTimes);
        genderMaleButton = new JRadioButton("m");
        genderFemaleButton = new JRadioButton("f");
        genderOtherButton = new JRadioButton("o");

        ageSpinner = new JSpinner();

        errorLabel = new JLabel("", JLabel.RIGHT);

        final int border = 20;
        final int gap = 10;
        final int width1 = 125, width2 = 200;
        final int x2 = width1 + border + gap;
        final int spacing = border + gap;

        String[] labelText = {"Name: ", "Email: ", "Phone Number: ",
                "Gender: ", "Age: ", "Destination: ", "Departure Time: "};

        for (int i = 0; i < labelText.length; i++) {
            addLabelToFrame(labelText[i], spacing, border, border, width1, border, i);
        }

        nameField.setBounds(x2, border, width2, border);
        f.add(nameField);

        emailField.setBounds(x2, border + spacing, width2, border);
        f.add(emailField);

        phoneNumberField.setBounds(x2, border + (2 * spacing), width2, border);
        f.add(phoneNumberField);

        ButtonGroup bg = new ButtonGroup();

        genderMaleButton.setBounds(x2, border + (3 * spacing), width2/4, border);
        bg.add(genderMaleButton);
        f.add(genderMaleButton);

        genderFemaleButton.setBounds(x2 + 50, border + (3 * spacing), width2/4, border);
        bg.add(genderFemaleButton);
        f.add(genderFemaleButton);

        genderOtherButton.setBounds(x2 + 100, border + (3 * spacing), width2/4, border);
        bg.add(genderOtherButton);
        f.add(genderOtherButton);

        ageSpinner.setBounds(x2, border + (4 * spacing), width2/4, border);
        f.add(ageSpinner);

        destinationField.setBounds(x2, border + (5 * spacing), width2, border);
        f.add(destinationField);

        departureTimeField.setBounds(x2, border + (6 * spacing), width2, border);
        f.add(departureTimeField);

        JButton b = new JButton("submit");
        b.setBounds(x2, border + (labelText.length * spacing), width2, (border * 2));
        b.addActionListener(new sentButtonClickedActionListener());
        f.add(b);

        errorLabel.setBounds(x2, border + ((labelText.length + 2) * spacing), width2, border);
        f.add(errorLabel);

        f.setSize((width2 * 2), ((border + spacing) * labelText.length));
        f.setVisible(true);
    }

    /**
     * gui window that displays the ticket information to the user.
     * returns to the original window so another user can fill out a new form once the ok button is clicked.
     * @param t the ticket to display information for
     */
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

        JButton b = new JButton("OK");
        b.setBounds((width / 2) - 10, y + (labelText.length * spacing), width, (height * 2));
        f.add(b);

        b.addActionListener(new okButtonClickedActionListener());

        f.setSize((width * 2), ((height + spacing) * (labelText.length - 1)));
        f.setVisible(true);
    }

    /**
     * is used to arrange JLabel components in a vertical column.
     * each component is placed y + (index * spacing) units below the first
     * @param labelString the string for the JLabel
     * @param spacing how far apart each component should be
     * @param x the horizontal alignment of the components
     * @param y the y value of the first component at index 0
     * @param width how wide the component should be
     * @param height how tall the component should be
     * @param index how many components worth of space should be given
     */
    private static void addLabelToFrame(String labelString,
                                        int spacing, int x, int y, int width, int height, int index) {

        JLabel label = new JLabel(labelString, JLabel.RIGHT);
        label.setBounds(x, y + (index * spacing), width - 10, height);
        f.add(label);
    }

    /**
     * is used to arrange JLabel components in two vertical columns.
     * labelString is for the first column and infoString is next to them on the second column
     * each component is placed y + (index * spacing) units below the first
     * @param labelString the string for the JLabel
     * @param spacing how far apart each component should be
     * @param x the horizontal alignment of the components
     * @param y the y value of the first component at index 0
     * @param width how wide the component should be
     * @param height how tall the component should be
     * @param index how many components worth of space should be given
     */
    private static void addLabelAndInfoToFrame(String labelString, String infoString,
                                               int spacing, int x, int y, int width, int height, int index) {

        JLabel label = new JLabel(labelString, JLabel.RIGHT);
        JLabel info = new JLabel(infoString, JLabel.LEFT);

        label.setBounds(x, y + (index * spacing), width - 10, height);
        info.setBounds(width + x, y + (index * spacing), width, height);
        f.add(label);
        f.add(info);
    }

    /**
     * utility method that makes sure a nullPointer exception is not created
     * @param age a string representing an age
     * @return age parsed into an integer, 0 when blank
     */
    private static int parseAge(String age) {
        if (!age.equals("")) {
            return Integer.parseInt(age);
        }
        return 0;
    }

    /**
     * the actionListener that collects all the information from the forms and makes sure they are valid.
     * if valid it creates a ticket using that information, writes it to a stub, and sends the user to the second gui.
     */
    private static class sentButtonClickedActionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String name = nameField.getText();
            String email = emailField.getText().toLowerCase();
            String phoneNumber = phoneNumberField.getText();

            String gender;
            if(genderMaleButton.isSelected()){
                gender = "male";
            }else if(genderFemaleButton.isSelected()){
                gender = "female";
            }else if(genderOtherButton.isSelected()){
                gender = "other";
            }else gender = "n/a";

            int age = parseAge(ageSpinner.getValue() + "");
            String destination = destinationField.getSelectedItem() + "";
            String departureTime = departureTimeField.getSelectedItem() + "";

            if(name.equals("")){
                errorLabel.setText("Please enter a valid name.");
            }else if(!email.matches(REGEX_FOR_EMAIL)){
                errorLabel.setText("Please enter a valid email.");
            }else if(!phoneNumber.matches(REGEX_FOR_PHONE)){
                errorLabel.setText("Please enter a valid phone number.");
            }else if(age < 0 || age >= 150){
                errorLabel.setText("Enter a valid age.");
            }else{
                User u = new User(name, email, phoneNumber, gender, age, destination, departureTime);
                Ticket t = new Ticket(u);
                TicketProcessor.writeTicketStub(t);
                launchSecondGui(t);
            }
        }
    }

    /**
     * the action click listener for the ok button that returns the user back to the first gui window.
     */
    private static class okButtonClickedActionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            launchGui();
        }
    }
}
