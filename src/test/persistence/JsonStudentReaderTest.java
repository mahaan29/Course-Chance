package persistence;

import model.CourseStorage;
import model.StudentAuthentication;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class JsonStudentReaderTest {

    @Test
    void testReaderNonExistentFile() {
        StudentReader studentReader = new StudentReader("./data/noSuchFile.json");
        try {
            StudentAuthentication studentAuthentication = (StudentAuthentication) studentReader.read();
            fail("IOException expected");
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    void testReaderEmptyStudentAuthentication() {
        StudentReader studentReader = new StudentReader("./data/testWriterEmptyStudentAuthentication.json");
        try {
            StudentAuthentication studentAuthentication = (StudentAuthentication) studentReader.read();
            assertEquals(0,studentAuthentication.getStudentList().size());
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }

    @Test
    void testReaderStudentAuthentication() {
        StudentReader studentReader = new StudentReader("./data/testWriterStudentAuthentication.json");
        try {
            StudentAuthentication studentAuthentication = (StudentAuthentication) studentReader.read();
            assertEquals(2, studentAuthentication.getStudentList().size());
            assertEquals("CPSC 210", studentAuthentication.getStudentList().get(0).getCourseRegistered().get(0).getCourseName());
            assertEquals("CPSC 121", studentAuthentication.getStudentList().get(0).getCourseRegistered().get(1).getCourseName());
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }
}