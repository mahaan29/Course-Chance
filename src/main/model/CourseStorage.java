package model;

import model.exceptions.DuplicateCourseException;
import org.json.JSONArray;
import org.json.JSONObject;
import persistence.Writable;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

//CourseStorage class stores the list of available courses and allows user to perform their corresponding actions.
public class CourseStorage implements Writable {

    // Stores the total list of courses available
    protected static List<Course> courseList = new ArrayList<>();

    // Getter methods
    public List<Course> getCourseList() {
        return courseList;
    }


    // MODIFIES: courseList
    // EFFECTS: Adds a course to the list of available courses.

    public void addCourse(Course c) throws DuplicateCourseException {
        for (Course course : courseList) {
            if (c.getCourseName().equals(course.getCourseName())) {
                throw new DuplicateCourseException();
            }
        }
        courseList.add(c);
    }

    // REQUIRES: Name of the course which needs to be deleted from available courses.
    // MODIFIES: courseList
    // EFFECTS: Deletes a course from the list of available courses.

    public boolean deleteCourse(String name) {

        for (Course course : courseList) {
            if (course.getCourseName().equals(name)) {
                for (Student student : StudentAuthentication.getStudentList()) {
                    student.deregisterCourse(name);
                }


                courseList.remove(course);
                return true;
            }

        }
        return false;
    }

    public boolean deleteCourse(int index) {
        Course course = courseList.get(index);
        for (Student student : StudentAuthentication.getStudentList()) {
            student.deregisterCourse(course.getCourseName());
        }
        courseList.remove(course);
        return true;
    }



    // MODIFIES: counter, s
    // EFFECTS: Register the course to the student's worklist.

    public int registerCourse(String name, Student s) {
        for (Course course : courseList) {
            if (course.getCourseName().equals(name)) {
                if (!s.getCourseRegistered().contains(course)) {
                    s.setCourseRegistered(course);
                    course.incrementCounter();
                    return 0;
                } else {
                    return 1;
                }
            }
        }
        return 2;
    }

    // MODIFIES: counter, s
    // EFFECTS: De-registers the course from the student's worklist.

    public boolean unregisterCourse(String name, Student s) {
        for (Course course : s.getCourseRegistered()) {
            if (course.getCourseName().equals(name)) {
                s.deregisterCourse(name);
                course.decrementCounter();
                return true;
            }
        }
        return false;
    }

    // EFFECTS: copies the list of courses
    public void copyCourseList(List<Course> courses) {
        courseList = courses;
    }


    // EFFECTS: Returns this class as a JSON Object
    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        JSONArray jsonArray = new JSONArray();
        for (Course c : courseList) {
            jsonArray.put(c.toJson());
        }
        json.put("courseList", jsonArray);
        return json;
    }
}
