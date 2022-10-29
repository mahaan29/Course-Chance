package ui;

import java.util.*;

import model.CourseStorage;
import model.Course;
import model.exceptions.DuplicateCourseException;


// CourseGenerator is the part of Admin Portal which shows all the functionalities of the portal.
public class CourseGenerator {

    private CourseStorage courseStorage = new CourseStorage();



    // EFFECTS: Opens the courseOperations functions.
    public CourseGenerator() {
        //courseOperation();
    }

    // EFFECTS: Creates a new course and puts in the list of courses offered.
    // MODIFIES: courseList
    public boolean newCourse(Course course1) {

        try {
            courseStorage.addCourse(course1);
            return true;
        } catch (DuplicateCourseException e) {
            return false;
        }

    }

    // EFFECTS: Deletes a course from the list of courses offered.
    // MODIFIES: courseList
    public boolean removeCourse(int index) {

        return courseStorage.deleteCourse(index);

    }

    // EFFECTS: Returns a course list to the CourseGeneratorGUI
    public List<String> viewCourseGUI() {
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
}
