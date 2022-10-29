package ui;

import model.Course;
import model.CourseStorage;
import model.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// CourseRegistration is the part of Student Portal which implements all the functionalities of portal.
public class CourseRegistration {

    Scanner sc = new Scanner(System.in);
    private CourseStorage courseStorage = new CourseStorage();
    private Student student;

    // REQUIRES: a not null student object
    // MODIFIES: this
    // EFFECTS: Opens functions of courseActions
    public CourseRegistration(Student student) {

        this.student = student;
    }


    //EFFECTS: allows student to add addition, removal, view operations.
    public void courseActions() {

        System.out.println("Hello, " + student.getName() + ". Press: \n(1) to view list of all available courses");
        System.out.println("(2) to add course to your worklist\n(3) to remove course to your worklist.");
        System.out.println("(4) to view your status of the courses in the worklist.");
        System.out.println("(5) to Log Out");
        int a = sc.nextInt();

        if (a == 1) {
            viewCourses();
        }
        if (a == 2) {
            registerCourse();
        }
        if (a == 3) {
            deregisterCourse();
        }

        if (a == 4) {
            viewCourseStatus();
        }

        if (a == 5) {
            new WelcomeScreen();
        } else {
            System.out.println("Invalid input. Try again!");
            courseActions();
        }
    }

    // EFFECTS: Creates a new course and puts in the list of courses offered.
    // MODIFIES: courseList
    public void registerCourse() {

        System.out.println("What is the course name you would like to register in your worklist?");

        Scanner sc1 = new Scanner(System.in);
        String name = sc1.nextLine();

        if (courseStorage.registerCourse(name, student) == 0) {
            System.out.println("Course added successfully!");
        } else if (courseStorage.registerCourse(name, student) == 1) {
            System.out.println("You already added this course to your worklist!");
        } else {
            System.out.println("Course does not exist!");
        }

        courseActions();

    }

    // EFFECTS: Deletes a course from the list of courses offered.
    // MODIFIES: courseList
    public void deregisterCourse() {

        System.out.println("Enter the name of course which has to be deleted?");

        Scanner sc1 = new Scanner(System.in);
        String name = sc1.nextLine();

        if (courseStorage.unregisterCourse(name, student)) {
            System.out.println("Course has been deleted successfully.");
        } else {
            System.out.println("Course not found.");
        }
        courseActions();

    }

    // EFFECTS: Displays the list of courses offered.
    public void viewCourses() {
        if (courseStorage.getCourseList().size() != 0) {
            for (Course c : courseStorage.getCourseList()) {
                System.out.println("Course Name: " + c.getCourseName());
                System.out.println("Total number of available seats: " + c.getCourseSeats());
                System.out.println("Credits offered: " + c.getCourseCredits());
                System.out.println();
            }
        } else {
            System.out.println("No courses found!");
        }
        courseActions();
    }

    // EFFECTS: Displays the status of all the courses registered.
    public void viewCourseStatus() {
        if (student.getCourseRegistered().size() != 0) {
            for (Course courses : student.getCourseRegistered()) {
                System.out.println("Course Name: " + courses.getCourseName());
                courseChance(courses);
            }
        } else {
            System.out.println("No courses found!");
        }
        courseActions();
    }

    // EFFECTS: Displays the student's status in registered courses.
    public String courseChance(Course course) {
        double counter = course.getCounter();
        double seats = course.getCourseSeats();
        double ratio = counter / seats;
        if (ratio <= 1) {
            return "You're gucci! \nWhat this means: Total no. of seats available for this course "
                    + "is " + "sufficient for no. of students who have added this course to their worklist.";
        } else if (ratio > 1 && ratio < 1.2) {
            return "There's a solid chance you'll get this one! \n What this means: No. of students who"
                    + " added this course to their worklist is upto 20% more than total no. of seats available for"
                    + " this course";
        } else if (ratio >= 1.2 && ratio <= 1.5) {
            return "Eh. Just pray your registration time is sooner than others!\n"
                    + "What this means: No. of students who added this course to their worklist is about 20% -"
                    + " 50% more than total no. of seats available for this course.";
        } else {
            return "Sorry bud, there's a heavy chance you won't get this course. Consider other options as "
                    + "well.\n" + "What this means: No. of students who added this course to their worklist is 50% "
                    + "more " + "than the total no. of seats available for this course.";
        }
    }

    // EFFECTS: Returns a course list to the CourseGeneratorGUI
    public List<String> viewAllCoursesGUI() {
        List<String> list = new ArrayList<>();
        if (courseStorage.getCourseList().size() == 0) {
            list.add("No Courses have been created yet!");
        } else {
            for (int i = 0; i < courseStorage.getCourseList().size(); i++) {
                String entry = (i + 1) + "." + courseStorage.getCourseList().get(i).toString();
                list.add(entry);
            }
        }
        return list;
    }

    // EFFECTS: Returns a course list to the CourseGeneratorGUI
    public List<String> viewYourCoursesGUI() {
        List<String> list = new ArrayList<>();
        if (student.getCourseRegistered().size() == 0) {
            list.add("No Courses have been added to your Worklist yet!");
        } else {
            for (int i = 0; i < student.getCourseRegistered().size(); i++) {
                String entry = (i + 1) + "." + student.getCourseRegistered().get(i).toString();
                list.add(entry);
            }
        }
        return list;
    }
}
