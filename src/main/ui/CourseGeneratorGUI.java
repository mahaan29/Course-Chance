package ui;

import model.Course;

import javax.swing.*;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.List;

import static javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED;
import static javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED;

// CourseGeneratorGUI is the portal for admin to perform admin actions.
public class CourseGeneratorGUI extends JFrame {

    CourseGenerator courseGenerator = new CourseGenerator();
    JFrame mainFrame = new JFrame("Course Generator");
    JLabel title;
    JLabel courseNameLabel;
    JLabel courseCreditsLabel;
    JLabel courseSeatsLabel;
    JTextField courseNameField;
    JTextField courseCreditsField;
    JTextField courseSeatsField;

    List<String> courseList;
    JList<String> courseJList;
    DefaultListModel<String> courseListModel;

    JButton createCourse;
    JButton create;
    JButton removeCourse;
    JButton viewCourses;
    JButton delCourse;
    JButton signOut;
    JButton goBack;
    int index;

    // Default constructor for CourseGeneratorGUI class
    public CourseGeneratorGUI() {
        mainFrame.setSize(800, 500);
        mainFrame.setBackground(Color.BLACK);
        initializeCourseGenerator();
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setVisible(true);

    }

    // EFFECTS: initializes CourseGeneratorGUI Screen
    private void initializeCourseGenerator() {
        JPanel courseGeneratorScreen = new JPanel(new GridBagLayout());
        courseGeneratorScreen.setBackground(SystemColor.WHITE);
        GridBagConstraints courseGSConstraints = new GridBagConstraints();
        courseGSConstraints.insets = new Insets(10, 10, 10, 10);
        title = new JLabel("Course Portal");

        createCourse = new JButton("Create a Course");
        removeCourse = new JButton("Remove a Course");
        viewCourses = new JButton("View all Courses");
        signOut = new JButton("Sign Out");
        courseGeneratorScreenElements(courseGeneratorScreen, courseGSConstraints);
        mainFrame.add(courseGeneratorScreen);
    }

    // EFFECTS: extension to the method above. Displays the CourseGeneratorScreen elements.
    private void courseGeneratorScreenElements(JPanel courseGeneratorScreen, GridBagConstraints courseGSConstraints) {

        courseGSConstraints.anchor = GridBagConstraints.CENTER;
        courseGSConstraints.fill = GridBagConstraints.HORIZONTAL;

        courseGSConstraints.gridx = 0;
        courseGSConstraints.gridy = 0;
        courseGeneratorScreen.add(title);

        courseGSConstraints.gridx = 0;
        courseGSConstraints.gridy = 1;
        courseGeneratorScreen.add(createCourse, courseGSConstraints);
        ActionListener createCourseButton = createCourseButton(courseGeneratorScreen);
        createCourse.addActionListener(createCourseButton);
        courseGSConstraints.gridx = 0;
        courseGSConstraints.gridy = 2;
        courseGeneratorScreen.add(removeCourse, courseGSConstraints);
        ActionListener removeCourseButton = removeCourseButton(courseGeneratorScreen);
        removeCourse.addActionListener(removeCourseButton);
        courseGSConstraints.gridx = 0;
        courseGSConstraints.gridy = 3;
        courseGeneratorScreen.add(viewCourses, courseGSConstraints);
        ActionListener viewCoursesButton = viewCoursesButton(courseGeneratorScreen);
        viewCourses.addActionListener(viewCoursesButton);
        courseGeneratorScreenElements2(courseGeneratorScreen, courseGSConstraints, signOut, signOutCall());

    }

    // EFFECTS: extension to the method above. Displays the CourseGeneratorScreen elements.
    private void courseGeneratorScreenElements2(JPanel cgs, GridBagConstraints c, JButton e, ActionListener al) {
        c.gridx = 0;
        c.gridy = 4;
        cgs.add(e, c);
        e.addActionListener(al);
    }

    // EFFECTS: Displays elements for createCourse tab.
    private void createCourse() {
        JPanel createCourseScreen = new JPanel(new GridBagLayout());
        createCourseScreen.setBackground(SystemColor.WHITE);
        GridBagConstraints createCSConstraints = new GridBagConstraints();
        createCSConstraints.insets = new Insets(10, 10, 10, 10);
        title = new JLabel("Create a Course");
        courseNameLabel = new JLabel("Course Name:");
        courseCreditsLabel = new JLabel("Credit(s):");
        courseSeatsLabel = new JLabel("Total Seats:");
        courseNameField = new JTextField(10);
        courseCreditsField = new JTextField(10);
        courseSeatsField = new JTextField(10);
        create = new JButton("Create Course");
        goBack = new JButton("Go Back to Account");
        createCourseScreenElements(createCourseScreen, createCSConstraints);
        mainFrame.add(createCourseScreen);
    }

    // EFFECTS: Extension to the method above. Displays createCourseScreen elements.
    private void createCourseScreenElements(JPanel createCourseScreen, GridBagConstraints createCSConstraints) {
        createCSConstraints.fill = GridBagConstraints.HORIZONTAL;
        createCSConstraints.gridx = 0;
        createCSConstraints.gridy = 0;
        createCourseScreen.add(title, createCSConstraints);

        createCSConstraints.gridx = 0;
        createCSConstraints.gridy = 1;
        createCourseScreen.add(courseNameLabel, createCSConstraints);
        createCSConstraints.gridx = 1;
        createCSConstraints.gridy = 1;
        createCourseScreen.add(courseNameField, createCSConstraints);

        createCSConstraints.gridx = 0;
        createCSConstraints.gridy = 2;
        createCourseScreen.add(courseCreditsLabel, createCSConstraints);
        createCSConstraints.gridx = 1;
        createCSConstraints.gridy = 2;
        createCourseScreen.add(courseCreditsField, createCSConstraints);

        createCSConstraints.gridx = 0;
        createCSConstraints.gridy = 3;
        createCourseScreen.add(courseSeatsLabel, createCSConstraints);
        createCSConstraints.gridx = 1;
        createCSConstraints.gridy = 3;
        createCourseScreen.add(courseSeatsField, createCSConstraints);

        createCourseScreenElements2(createCourseScreen, createCSConstraints);

    }

    // EFFECTS: Extension to the method above. Displays createCourseScreen elements.
    private void createCourseScreenElements2(JPanel createCourseScreen, GridBagConstraints createCSConstraints) {
        createCSConstraints.gridx = 0;
        createCSConstraints.gridy = 4;
        createCourseScreen.add(create, createCSConstraints);
        ActionListener createCall = createCall(createCourseScreen);
        create.addActionListener(createCall);
        createCSConstraints.gridx = 0;
        createCSConstraints.gridy = 5;
        createCourseScreen.add(goBack, createCSConstraints);
        ActionListener goBackCall = goBackCall(createCourseScreen);
        goBack.addActionListener(goBackCall);
    }

    // EFFECTS: Displays elements for removeCourse tab.
    private void removeCourse() {
        JPanel removeCourseScreen = new JPanel(new GridBagLayout());
        removeCourseScreen.setBackground(SystemColor.WHITE);
        GridBagConstraints removeCSConstraints = new GridBagConstraints();
        removeCSConstraints.insets = new Insets(10, 10, 10, 10);
        title = new JLabel("Remove a Course");
        delCourse = new JButton("Delete");
        goBack = new JButton("Go Back to Account");
        courseList = courseGenerator.viewCourseGUI();
        courseListModel = new DefaultListModel<>();
        for (String s : courseList) {
            courseListModel.addElement(s);
        }
        courseJList = new JList<>();
        courseJList.setModel(courseListModel);
        courseJList.setSize(new Dimension(800, 300));
        courseJList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        courseJList.setVisibleRowCount(4);
        removeCourseScreenElements(removeCourseScreen, removeCSConstraints);
        mainFrame.add(removeCourseScreen);
    }

    // EFFECTS: Extension to the method above. Displays removeCourseScreen elements.
    private void removeCourseScreenElements(JPanel removeCourseScreen, GridBagConstraints removeCSConstraints) {
        JScrollPane remScrollPane;
        remScrollPane = new JScrollPane(courseJList, VERTICAL_SCROLLBAR_AS_NEEDED, HORIZONTAL_SCROLLBAR_AS_NEEDED);
        remScrollPane.setSize(new Dimension(800, 300));
        removeCSConstraints.fill = GridBagConstraints.HORIZONTAL;
        removeCSConstraints.gridx = 0;
        removeCSConstraints.gridy = 0;
        removeCourseScreen.add(title, removeCSConstraints);
        removeCSConstraints.gridx = 0;
        removeCSConstraints.gridy = 1;
        removeCourseScreen.add(remScrollPane, removeCSConstraints);
        ListSelectionListener courseSelectionFromList = courseSelectionFromList(removeCourseScreen);
        courseJList.addListSelectionListener(courseSelectionFromList);
        removeCSConstraints.gridx = 0;
        removeCSConstraints.gridy = 2;
        removeCourseScreen.add(goBack, removeCSConstraints);
        ActionListener goBackCall = goBackCall(removeCourseScreen);
        goBack.addActionListener(goBackCall);
    }

    //EFFECTS: Constructs the GUI Elements for the View Course Scroll Panel Page
    private void viewCourses() {
        JPanel viewCourseScreen = new JPanel(new GridBagLayout());
        viewCourseScreen.setBackground(SystemColor.WHITE);
        GridBagConstraints viewCSConstraints = new GridBagConstraints();
        viewCSConstraints.insets = new Insets(10, 10, 10, 10);
        title = new JLabel("View all Courses");
        goBack = new JButton("Go Back to Account");
        courseList = courseGenerator.viewCourseGUI();
        courseListModel = new DefaultListModel<>();
        for (String s : courseList) {
            courseListModel.addElement(s);
        }
        courseJList = new JList<>();
        courseJList.setModel(courseListModel);
        courseJList.setSize(new Dimension(800, 300));
        courseJList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        courseJList.setVisibleRowCount(4);
        viewCoursesScreenElements(viewCourseScreen, viewCSConstraints);
        mainFrame.add(viewCourseScreen);

    }

    //EFFECTS: Extension of the method above, it constructs the GUI Elements for the View Course Scroll Panel Page
    private void viewCoursesScreenElements(JPanel viewCourseScreen, GridBagConstraints viewCSConstraints) {
        JScrollPane viewScrollPane;
        viewScrollPane = new JScrollPane(courseJList, VERTICAL_SCROLLBAR_AS_NEEDED, HORIZONTAL_SCROLLBAR_AS_NEEDED);
        viewScrollPane.setSize(new Dimension(800, 300));
        viewCSConstraints.fill = GridBagConstraints.HORIZONTAL;
        viewCSConstraints.gridx = 0;
        viewCSConstraints.gridy = 0;
        viewCourseScreen.add(title, viewCSConstraints);
        viewCSConstraints.gridx = 0;
        viewCSConstraints.gridy = 1;
        viewCourseScreen.add(viewScrollPane, viewCSConstraints);
        viewCSConstraints.gridx = 0;
        viewCSConstraints.gridy = 2;
        viewCourseScreen.add(goBack, viewCSConstraints);
        ActionListener goBackCall = goBackCall(viewCourseScreen);
        goBack.addActionListener(goBackCall);
    }

    // EFFECTS: adds an ActionListener for goBackButton
    private ActionListener goBackCall(JPanel panel) {
        return e -> {
            panel.setVisible(false);
            initializeCourseGenerator();
        };
    }

    // EFFECTS: adds an ActionListener for viewCoursesButton and initializes the viewCourses method.
    private ActionListener viewCoursesButton(JPanel panel) {
        return e -> {
            panel.setVisible(false);
            viewCourses();
        };
    }

    // EFFECTS: adds an ActionListener for removeCourseButton and initializes the removeCourse method.
    private ActionListener removeCourseButton(JPanel panel) {
        return e -> {
            panel.setVisible(false);
            removeCourse();
        };
    }

    // EFFECTS: adds an ActionListener for createCourseButton and initializes the createCourse method.
    private ActionListener createCourseButton(JPanel panel) {
        return e -> {
            panel.setVisible(false);
            createCourse();
        };
    }

    // MODIFIES: courseGenerator
    // EFFECTS: adds a new course to the list of courses by getting the required values from the user.
    private ActionListener createCall(JPanel panel) {
        return e -> {
            panel.setVisible(false);
            String name = courseNameField.getText();
            int credits = Integer.parseInt(courseCreditsField.getText());
            int seats = Integer.parseInt(courseSeatsField.getText());
            Course course = new Course(name,seats,credits,0);
            if (courseGenerator.newCourse(course)) {
                JOptionPane.showMessageDialog(mainFrame, "Course Added Successfully!");
            } else {
                JOptionPane.showMessageDialog(mainFrame, "Course Already Added! Try Again!");
            }
            panel.setVisible(false);
            mainFrame.dispose();
            new CourseGeneratorGUI();
        };
    }

    // EFFECTS: adds an ActionListener for the signOut button.
    private ActionListener signOutCall() {
        return e -> {
            mainFrame.dispose();
            new AdminScreenGUI();
        };
    }

    // MODIFIES: CourseGenerator
    // EFFECTS: adds a list selection listener that removes the selected course.
    private ListSelectionListener courseSelectionFromList(JPanel panel) {
        return e -> {
            index = courseJList.getSelectedIndex();
            int input = JOptionPane.showConfirmDialog(null,
                    "Click Yes to delete Course: " + (index + 1), "Course Deletion Confirmation",
                    JOptionPane.YES_NO_CANCEL_OPTION);
            panel.setVisible(false);
            if (input == 0 && courseGenerator.removeCourse(index)) {
                JOptionPane.showMessageDialog(mainFrame,"Course number " + (index + 1) + " deleted!");
            } else {
                JOptionPane.showMessageDialog(mainFrame,"Unable to delete Course!");
            }
            mainFrame.dispose();
            new CourseGeneratorGUI();
        };
    }
}
