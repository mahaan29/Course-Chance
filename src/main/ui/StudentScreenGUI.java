package ui;

import model.Student;
import model.StudentAuthentication;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

// StudentScreenGUI is the landing page of studentPortal where student can access their account.
public class StudentScreenGUI extends JFrame {

    JFrame mainFrame = new JFrame("Student Portal");
    StudentAuthentication studentAuthentication = new StudentAuthentication();

    JLabel title;
    JLabel emailLabel;
    JLabel passwordLabel;
    JTextField emailField;
    JTextField passwordField;
    JButton loginButton;

    JButton goBack;

    JButton signUpButton;
    JButton signUpButton2;
    JLabel signUpTitleLabel;
    JLabel signUpNameLabel;
    JLabel signUpEmailLabel;
    JLabel signUpPasswordLabel;
    JTextField signUpNameField;
    JTextField signUpEmailField;
    JTextField signUpPasswordField;

    // Default constructor of studentScreenGUI
    public StudentScreenGUI() {
        mainFrame.setSize(800,500);
        mainFrame.setBackground(Color.BLACK);
        initializeStudentScreen();
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setVisible(true);
    }

    // EFFECTS: initializes elements of StudentScreen.
    private void initializeStudentScreen() {
        JPanel studentScreen = new JPanel(new GridBagLayout());
        studentScreen.setBackground(SystemColor.WHITE);
        GridBagConstraints studentScreenConstraints = new GridBagConstraints();
        studentScreenConstraints.insets = new Insets(10, 10, 10, 10);
        title = new JLabel("Student Portal");

        emailLabel = new JLabel("Enter e-mail:");
        passwordLabel = new JLabel("Enter password:");
        emailField = new JTextField(10);
        passwordField = new JTextField(10);

        loginButton = new JButton("Log In");
        signUpButton = new JButton("Sign Up");
        goBack = new JButton("Go back to Home Screen");
        studentScreenElements(studentScreen, studentScreenConstraints);
        mainFrame.add(studentScreen);
    }

    // EFFECTS: Extension to the method above and displays elements of StudentScreen
    private void studentScreenElements(JPanel studentScreen, GridBagConstraints studentScreenConstraints) {

        studentScreenConstraints.gridx = 0;
        studentScreenConstraints.gridy = 0;
        studentScreen.add(title);
        studentScreenConstraints.anchor = GridBagConstraints.CENTER;

        studentScreenConstraints.fill = GridBagConstraints.HORIZONTAL;

        studentScreenConstraints.gridx = 0;
        studentScreenConstraints.gridy = 1;
        studentScreen.add(emailLabel, studentScreenConstraints);
        studentScreenConstraints.gridx = 1;
        studentScreenConstraints.gridy = 1;
        studentScreen.add(emailField, studentScreenConstraints);

        studentScreenConstraints.gridx = 0;
        studentScreenConstraints.gridy = 2;
        studentScreen.add(passwordLabel, studentScreenConstraints);
        studentScreenConstraints.gridx = 1;
        studentScreenConstraints.gridy = 2;
        studentScreen.add(passwordField, studentScreenConstraints);


        studentScreenElements2(studentScreen, studentScreenConstraints);

    }

    // EFFECTS: Extension to the method above and displays elements of StudentScreen
    private void studentScreenElements2(JPanel studentScreen, GridBagConstraints studentScreenConstraints) {
        studentScreenConstraints.gridx = 0;
        studentScreenConstraints.gridy = 3;
        studentScreen.add(loginButton, studentScreenConstraints);
        ActionListener loginCall = loginButton(studentScreen);
        loginButton.addActionListener(loginCall);

        studentScreenConstraints.gridx = 0;
        studentScreenConstraints.gridy = 4;
        studentScreen.add(signUpButton, studentScreenConstraints);
        ActionListener signUpCall = signUpButton(studentScreen);
        signUpButton.addActionListener(signUpCall);

        studentScreenConstraints.gridx = 0;
        studentScreenConstraints.gridy = 5;
        studentScreen.add(goBack, studentScreenConstraints);
        ActionListener goBackCall = goBackButton(studentScreen);
        goBack.addActionListener(goBackCall);
    }

    // EFFECTS: initializes the studentSignUpScreen elements.
    private void studentSignUp() {
        JPanel studentSignUpScreen = new JPanel(new GridBagLayout());
        studentSignUpScreen.setBackground(Color.WHITE);
        GridBagConstraints studentSignUpConstraints = new GridBagConstraints();
        studentSignUpConstraints.insets = new Insets(10, 10, 10, 10);
        signUpTitleLabel = new JLabel("Sign Up");

        signUpNameLabel = new JLabel("Name: ");
        signUpEmailLabel = new JLabel("E-mail address: ");
        signUpPasswordLabel = new JLabel("Password: ");

        signUpNameField = new JTextField(10);
        signUpEmailField = new JTextField(10);
        signUpPasswordField = new JTextField(10);

        signUpButton2 = new JButton("Sign Up");
        goBack = new JButton("Go Back to Student Screen");

        studentSignUpElements(studentSignUpScreen, studentSignUpConstraints);
        mainFrame.add(studentSignUpScreen);
    }

    // EFFECTS: Extension to the method above. initializes the studentSignUpScreen elements.
    private void studentSignUpElements(JPanel studentSignUpScreen, GridBagConstraints studentSignUpConstraints) {
        studentSignUpConstraints.gridx = 0;
        studentSignUpConstraints.gridy = 0;
        studentSignUpScreen.add(signUpNameLabel, studentSignUpConstraints);
        studentSignUpConstraints.gridx = 1;
        studentSignUpConstraints.gridy = 0;
        studentSignUpScreen.add(signUpNameField, studentSignUpConstraints);

        studentSignUpConstraints.gridx = 0;
        studentSignUpConstraints.gridy = 2;
        studentSignUpScreen.add(signUpEmailLabel, studentSignUpConstraints);
        studentSignUpConstraints.gridx = 1;
        studentSignUpConstraints.gridy = 2;
        studentSignUpScreen.add(signUpEmailField, studentSignUpConstraints);

        studentSignUpConstraints.gridx = 0;
        studentSignUpConstraints.gridy = 3;
        studentSignUpScreen.add(signUpPasswordLabel, studentSignUpConstraints);
        studentSignUpConstraints.gridx = 1;
        studentSignUpConstraints.gridy = 3;
        studentSignUpScreen.add(signUpPasswordField, studentSignUpConstraints);

        studentSignUpElements2(studentSignUpScreen, studentSignUpConstraints);
    }

    // EFFECTS: Extension to the method above. initializes the studentSignUpScreen elements.
    private void studentSignUpElements2(JPanel studentSignUpScreen, GridBagConstraints studentSignUpConstraints) {

        studentSignUpConstraints.gridx = 0;
        studentSignUpConstraints.gridy = 6;
        studentSignUpScreen.add(signUpButton2, studentSignUpConstraints);
        ActionListener signUpCall = signUpButton2();
        signUpButton2.addActionListener(signUpCall);

        studentSignUpConstraints.gridx = 0;
        studentSignUpConstraints.gridy = 7;
        studentSignUpScreen.add(goBack, studentSignUpConstraints);
        ActionListener goBackCall = backToStudentScreen(studentSignUpScreen);
        goBack.addActionListener(goBackCall);
    }

    // EFFECTS: adds ActionListener for goBackButton.
    private ActionListener goBackButton(JPanel panel) {
        return e -> {
            panel.setVisible(false);
            mainFrame.dispose();
            new WelcomeScreenGUI();
        };
    }

    // EFFECTS: adds ActionListener to backToStudentScreenButton
    private ActionListener backToStudentScreen(JPanel panel) {
        return e -> {
            panel.setVisible(false);
            mainFrame.dispose();
            new StudentScreenGUI();
        };
    }

    // EFFECTS: adds ActionListener to loginButton
    private ActionListener loginButton(JPanel panel) {
        return e -> {
            String email = emailField.getText();
            String password = passwordField.getText();
            Student student = studentAuthentication.validateStudent(email, password);
            if (student != null) {
                JOptionPane.showMessageDialog(mainFrame, "Login Successful!");
                panel.setVisible(false);
                mainFrame.dispose();
                new CourseRegistrationGUI(student);
            } else {
                JOptionPane.showMessageDialog(mainFrame, "Wrong email/password. Please try again!");
            }
        };
    }

    // EFFECTS: adds ActionListener to signUpButton
    private ActionListener signUpButton(JPanel panel) {
        return e -> {
            panel.setVisible(false);
            studentSignUp();
        };
    }

    // MODIFIES: StudentAuthentication
    // EFFECTS: Extension to the method above.
    private ActionListener signUpButton2() {
        return e -> {
            String name = signUpNameField.getText();
            String email = signUpEmailField.getText();
            String password = signUpPasswordField.getText();
            if (studentAuthentication.newStudent(new Student(name, email, password))) {
                JOptionPane.showMessageDialog(mainFrame, "Sign Up Successful!");
                mainFrame.dispose();
                new StudentScreenGUI();
            } else {
                JOptionPane.showMessageDialog(mainFrame, "This email is already registered! Try again.");
            }
        };
    }
}
