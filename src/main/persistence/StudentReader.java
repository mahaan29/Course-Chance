package persistence;

import model.*;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import org.json.*;

// Represents a reader that reads Student data from JSON data stored in file.
public class StudentReader {
    private String source;

    // EFFECTS: constructs reader to read from source file.
    public StudentReader(String source) {
        this.source = source;
    }

    // EFFECTS: reads students from file and returns it.
    // throws an IOException if an error occurs when reading data from the file
    public StudentAuthentication read() throws IOException {
        String jsonData = readFile(source);
        JSONObject jsonObject = new JSONObject(jsonData);
        JSONArray studentArray = jsonObject.getJSONArray("studentList");
        ArrayList<Student> students = new ArrayList<>();
        for (Object s : studentArray) {
            JSONObject courseObject = (JSONObject) s;
            String name = courseObject.getString("name");
            String email = courseObject.getString("email");
            String password = courseObject.getString("password");

            Student student = new Student(name, email, password);
            student.copyCourseList(parseCourseList(courseObject));
            students.add(student);
        }
        StudentAuthentication studentAuthentication = new StudentAuthentication();
        studentAuthentication.copyStudentList(students);
        return studentAuthentication;

    }

    // EFFECTS: Parses the registered courses from JSONObject and returns the list.
    public List<Course> parseCourseList(JSONObject jsonObject) {

        JSONArray courseArray = jsonObject.getJSONArray("courseRegistered");

        ArrayList<Course> courses = new ArrayList<>();
        for (Object e : courseArray) {
            JSONObject courseObject = (JSONObject) e;
            String courseName = courseObject.getString("courseName");
            int courseSeats = courseObject.getInt("courseSeats");
            int courseCredits = courseObject.getInt("courseCredits");
            int counter = courseObject.getInt("counter");
            courses.add(new Course(courseName, courseSeats, courseCredits, counter));
        }

        return courses;
    }

    // EFFECTS: reads source file as string and returns it
    private String readFile(String source) throws IOException {
        StringBuilder contentBuilder = new StringBuilder();

        try (Stream<String> stream = Files.lines(Paths.get(source), StandardCharsets.UTF_8)) {
            stream.forEach(s -> contentBuilder.append(s));
        }

        return contentBuilder.toString();
    }

}
