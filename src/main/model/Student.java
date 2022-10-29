package model;

import org.json.JSONArray;
import org.json.JSONObject;
import persistence.Writable;

import java.util.*;

// Student class holds the basic information of Students on the portal
public class Student extends Member implements Writable {

    // courseRegistered stores the list of courses registered by a student on the worklist.
    protected List<Course> courseRegistered;


    // Parametrized Constructor
    // MODIFIES: this
    // EFFECTS: creates a Course ArrayList
    public Student(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.courseRegistered = new ArrayList<>();
    }

    //Getter methods
    public String getName() {
        return this.name;
    }

    public String getEmail() {
        return this.email;
    }

    public String getPassword() {
        return this.password;
    }

    public List<Course> getCourseRegistered() {
        return courseRegistered;
    }


    // REQUIRES: Course, which the student wants to register in their worklist.
    // MODIFIES: courseRegistered
    // EFFECTS: Registers the course in the student's worklist.

    public void setCourseRegistered(Course c) {
        courseRegistered.add(c);
    }

    // REQUIRES: Name of the course which needs to be de-registered from the worklist.
    // MODIFIES: courseRegistered
    // EFFECTS: De-registers the course in the student's worklist.

    public void deregisterCourse(String name) {
        courseRegistered.removeIf(course -> course.getCourseName().equals(name));
    }

    // MODIFIES: this
    // EFFECTS: Copies the JSON Array to courseRegistered List
    public void copyCourseList(List<Course> courseRegistered) {
        this.courseRegistered = courseRegistered;
    }


    // EFFECTS: Returns this class as a JSON Object
    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("name", name);
        json.put("email", email);
        json.put("password", password);
        JSONArray jsonArray = new JSONArray();
        for (Course c : courseRegistered) {
            jsonArray.put(c.toJson());
        }
        json.put("courseRegistered", jsonArray);
        return json;
    }
}
