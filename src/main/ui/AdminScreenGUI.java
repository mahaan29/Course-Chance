package ui;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

// AdminScreenGUI is the landing screen for admin user.
public class AdminScreenGUI extends JFrame {

    JFrame mainFrame = new JFrame("Admin Portal");
    JLabel title;
    JLabel emailLabel;
    JLabel passwordLabel;
    JTextField emailField;
    JTextField passwordField;
    JButton loginButton;
    JButton goBack;

    // default constructor of admin screen.
    public AdminScreenGUI() {
        mainFrame.setSize(800,500);
        mainFrame.setBackground(Color.BLACK);
        initializeAdminScreen();
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setVisible(true);
    }

    // EFFECTS: initializes admin screen elements.
    public void initializeAdminScreen() {
        JPanel adminScreen = new JPanel(new GridBagLayout());
        adminScreen.setBackground(SystemColor.WHITE);
        GridBagConstraints adminScreenConstraints = new GridBagConstraints();
        adminScreenConstraints.insets = new Insets(10, 10, 10, 10);
        title = new JLabel("Admin Portal");
        emailLabel = new JLabel("Enter Admin ID:");
        passwordLabel = new JLabel("Enter password:");
        emailField = new JTextField(10);
        passwordField = new JTextField(10);
        loginButton = new JButton("Log In");
        goBack = new JButton("Go Back to Home Screen");
        adminScreenElements(adminScreen, adminScreenConstraints);
        mainFrame.add(adminScreen);
    }

    // EFFECTS: extension to the method above. Displays admin screen elements.
    private void adminScreenElements(JPanel adminScreen, GridBagConstraints adminScreenConstraints) {
        adminScreenConstraints.gridx = 0;
        adminScreenConstraints.gridy = 0;
        adminScreen.add(title);
        adminScreenConstraints.anchor = GridBagConstraints.CENTER;
        adminScreenConstraints.fill = GridBagConstraints.HORIZONTAL;
        adminScreenConstraints.gridx = 0;
        adminScreenConstraints.gridy = 1;
        adminScreen.add(emailLabel, adminScreenConstraints);
        adminScreenConstraints.gridx = 1;
        adminScreenConstraints.gridy = 1;
        adminScreen.add(emailField, adminScreenConstraints);
        adminScreenConstraints.gridx = 0;
        adminScreenConstraints.gridy = 2;
        adminScreen.add(passwordLabel, adminScreenConstraints);
        adminScreenConstraints.gridx = 1;
        adminScreenConstraints.gridy = 2;
        adminScreen.add(passwordField, adminScreenConstraints);
        adminScreenElements2(adminScreen, adminScreenConstraints);
    }

    // EFFECTS: extension to the method above. Displays admin screen elements.
    private void adminScreenElements2(JPanel adminScreen, GridBagConstraints adminScreenConstraints) {
        adminScreenConstraints.gridx = 0;
        adminScreenConstraints.gridy = 3;
        adminScreen.add(loginButton, adminScreenConstraints);
        ActionListener loginCall = loginButton(adminScreen);
        loginButton.addActionListener(loginCall);
        adminScreenConstraints.gridx = 0;
        adminScreenConstraints.gridy = 4;
        adminScreen.add(goBack, adminScreenConstraints);
        ActionListener goBackCall = goBackButton(adminScreen);
        goBack.addActionListener(goBackCall);
    }

    // EFFECTS: ActionListener for goBackButton
    private ActionListener goBackButton(JPanel panel) {
        return e -> {
            panel.setVisible(false);
            mainFrame.dispose();
            new WelcomeScreenGUI();
        };
    }

    // EFFECTS: ActionListener for login button
    private ActionListener loginButton(JPanel panel) {
        return e -> {
            String email = emailField.getText();
            String password = passwordField.getText();
            if (email.equals("admin@ubc.ca") && password.equals("admin")) {
                JOptionPane.showMessageDialog(mainFrame, "Login Successful!");
                panel.setVisible(false);
                mainFrame.dispose();
                new CourseGeneratorGUI();
            } else {
                JOptionPane.showMessageDialog(mainFrame, "Wrong email/password. Please try again!");
            }
        };
    }
}
