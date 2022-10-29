package persistence;

import model.*;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.stream.Stream;

import org.json.*;

// Represents a reader that reads Course data from JSON data stored in file.
public class CourseReader {
    private String source;

    // EFFECTS: constructs reader to read from source file.
    public CourseReader(String source) {
        this.source = source;
    }

    // EFFECTS: reads courses from file and returns it.
    // throws an IOException if an error occurs when reading data from the file
    public CourseStorage read() throws IOException {
        String jsonData = readFile(source);
        JSONObject jsonObject = new JSONObject(jsonData);
        JSONArray courseArray = jsonObject.getJSONArray("courseList");

        ArrayList<Course> courses = new ArrayList<>();
        for (Object e : courseArray) {
            JSONObject courseObject = (JSONObject) e;
            String name = courseObject.getString("courseName");
            int courseSeats = courseObject.getInt("courseSeats");
            int courseCredits = courseObject.getInt("courseCredits");
            int counter = courseObject.getInt("counter");
            courses.add(new Course(name, courseSeats, courseCredits, counter));
        }
        CourseStorage courseStorage = new CourseStorage();
        courseStorage.copyCourseList(courses);

        return courseStorage;

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
