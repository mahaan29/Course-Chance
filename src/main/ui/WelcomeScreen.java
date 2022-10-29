package ui;

import model.CourseStorage;
import model.StudentAuthentication;
import persistence.StudentReader;
import persistence.StudentWriter;

import persistence.CourseReader;
import persistence.CourseWriter;

import java.io.FileNotFoundException;
import java.io.IOException;


// WelcomeScreen is the first part of the application where the user lands after the program starts.
public class WelcomeScreen {

    StudentReader studentReader = new StudentReader("./data/StudentAuthentication.json");
    StudentWriter studentWriter = new StudentWriter("./data/StudentAuthentication.json");

    CourseReader courseReader = new CourseReader("./data/CourseStorage.json");
    CourseWriter courseWriter = new CourseWriter("./data/CourseStorage.json");

    StudentAuthentication studentAuthentication = new StudentAuthentication();
    CourseStorage courseStorage = new CourseStorage();

    // EFFECTS: Constructs WelcomeScreen and opens the main screen of the application.
    public WelcomeScreen() {
        //displayMessage();
    }


    // EFFECTS: Saves the data in .json format
    protected void saveData() {
        try {
            studentWriter.open();
            studentWriter.write(studentAuthentication);
            studentWriter.close();

            courseWriter.open();
            courseWriter.write(courseStorage);
            courseWriter.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
        }
    }

    // EFFECTS: loads the data from the .json file
    protected boolean loadData() {
        try {
            studentAuthentication = studentReader.read();
            courseStorage = courseReader.read();
            return true;
        } catch (IOException e) {
            return false;
        }

    }
}
