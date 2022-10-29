package model;

import org.json.JSONObject;
import persistence.Writable;


// Course class stores the information about the course available
public class Course implements Writable {

    // Stores the name of the course
    protected String courseName;

    // Stores the number of seats available for a course
    protected int courseSeats;

    // Stores the credits offered by the course
    protected int courseCredits;

    //Stores the number of students who registered the particular course in their worklist.
    protected int counter;

    // Parametrized Constructor
    public Course(String courseName, int courseSeats, int courseCredits, int counter) {
        this.courseName = courseName;
        this.courseSeats = courseSeats;
        this.courseCredits = courseCredits;
        this.counter = counter;
    }

    // MODIFIES: this
    public Course(String name) {
        this.courseName = name;
    }

    // Getter methods
    public String getCourseName() {
        return this.courseName;
    }

    public int getCourseSeats() {
        return this.courseSeats;
    }

    public int getCourseCredits() {
        return this.courseCredits;
    }

    public int getCounter() {
        return this.counter;
    }

    // MODIFIES: counter
    // EFFECTS: increments counter by 1.
    public void incrementCounter() {
        counter++;
    }

    // MODIFIES: counter
    // EFFECTS: decrements counter by 1.
    public void decrementCounter() {
        counter--;
    }

    @Override
    public String toString() {
        return "Name: " + courseName
                + " , Seats: " + courseSeats
                + " , Credits: " + courseCredits;
    }

    // EFFECTS: Returns this class as a JSON Object
    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("courseName", courseName);
        json.put("courseSeats", courseSeats);
        json.put("courseCredits", courseCredits);
        json.put("counter", counter);
        return json;
    }

}
