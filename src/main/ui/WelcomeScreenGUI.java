package ui;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

// WelcomeScreenGUI is the landing screen of the application which has different navigation options.
public class WelcomeScreenGUI extends JFrame {

    JFrame mainFrame = new JFrame("Course Chance");
    JButton studentPortal;
    JButton adminPortal;
    JButton exit;
    JButton load;
    JButton save;
    WelcomeScreen welcomeScreen = new WelcomeScreen();
    BufferedImage img;
    Image dummyImage;
    ImageIcon logo;
    JLabel mainLogo;
    boolean check;


    // EFFECTS: Default constructor for WelcomeScreenGUI class.
    public WelcomeScreenGUI() {
        mainFrame.setSize(800, 500);
        mainFrame.setBackground(Color.BLACK);
        try {
            img = ImageIO.read(new File("./data/logo.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        dummyImage = img.getScaledInstance(184, 104, Image.SCALE_SMOOTH);
        logo = new ImageIcon(dummyImage);
        initializeWelcomeScreen();
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setVisible(true);
    }

    // EFFECTS: initializes WelcomeScreen elements.
    public void initializeWelcomeScreen() {
        JPanel welcomeScreen = new JPanel(new GridBagLayout());
        welcomeScreen.setBackground(SystemColor.WHITE);
        GridBagConstraints welcomeScreenConstraints = new GridBagConstraints();
        welcomeScreenConstraints.insets = new Insets(10, 10, 10, 10);
        studentPortal = new JButton("Student Portal");
        adminPortal = new JButton("Admin Portal");
        save = new JButton("Save Records");
        load = new JButton("Load Records");
        exit = new JButton("Exit");
        mainLogo = new JLabel(logo);
        welcomeScreenElements(welcomeScreen, welcomeScreenConstraints);
        mainFrame.add(welcomeScreen);
    }

    // EFFECTS: Extension to the method above. Initializes WelcomeScreen elements.
    private void welcomeScreenElements(JPanel welcomeScreen, GridBagConstraints welcomeScreenConstraints) {
        welcomeScreenConstraints.anchor = GridBagConstraints.CENTER;
        welcomeScreenConstraints.gridx = 0;
        welcomeScreenConstraints.gridy = 0;
        welcomeScreen.add(mainLogo, welcomeScreenConstraints);
        welcomeScreenConstraints.fill = GridBagConstraints.HORIZONTAL;
        welcomeScreenConstraints.gridx = 0;
        welcomeScreenConstraints.gridy = 1;
        welcomeScreen.add(studentPortal, welcomeScreenConstraints);
        ActionListener studentPortalButton = studentPortalButton();
        studentPortal.addActionListener(studentPortalButton);
        welcomeScreenConstraints.gridx = 0;
        welcomeScreenConstraints.gridy = 2;
        welcomeScreen.add(adminPortal, welcomeScreenConstraints);
        ActionListener adminPortalButton = adminPortalButton();
        adminPortal.addActionListener(adminPortalButton);
        welcomeScreenConstraints.gridx = 0;
        welcomeScreenConstraints.gridy = 3;
        welcomeScreen.add(save, welcomeScreenConstraints);
        ActionListener saveCall = saveCall();
        save.addActionListener(saveCall);
        welcomeScreenElements2(welcomeScreen, welcomeScreenConstraints, exit, exitCall());
    }

    // EFFECTS: Extension to the method above. Initializes WelcomeScreen elements.
    private void welcomeScreenElements2(JPanel welcomeScreen, GridBagConstraints welcomeScreenConstraints,
                                        JButton exit, ActionListener actionListener) {
        welcomeScreenConstraints.gridx = 0;
        welcomeScreenConstraints.gridy = 4;
        welcomeScreen.add(load, welcomeScreenConstraints);
        ActionListener loadCall = loadCall();
        load.addActionListener(loadCall);

        welcomeScreenConstraints.gridx = 0;
        welcomeScreenConstraints.gridy = 5;
        welcomeScreen.add(exit, welcomeScreenConstraints);
        exit.addActionListener(actionListener);
    }

    // EFFECTS: adds ActionListener to studentPortalButton
    private ActionListener studentPortalButton() {
        return e -> {
            mainFrame.dispose();
            new StudentScreenGUI();
        };
    }

    // EFFECTS: adds ActionListener to adminPortalButton
    private ActionListener adminPortalButton() {
        return e -> {
            mainFrame.dispose();
            new AdminScreenGUI();
        };
    }

    // EFFECTS: adds ActionListener for exit button.
    private ActionListener exitCall() {
        return e -> System.exit(0);
    }

    // EFFECTS: adds ActionListener for save button and saveData method is implemented.
    private ActionListener saveCall() {
        return e -> welcomeScreen.saveData();
    }

    // EFFECTS: adds ActionListener for load button and loadData method is implemented.
    private ActionListener loadCall() {
        return e -> {
            if (welcomeScreen.loadData()) {
                JOptionPane.showMessageDialog(mainFrame, "Data loaded successfully!");
            } else {
                JOptionPane.showMessageDialog(mainFrame, "Data load unsuccessful!");
            }
        };

    }

}
