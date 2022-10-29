package persistence;

import model.CourseStorage;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class JsonCourseReaderTest {

    @Test
    void testReaderNonExistentFile() {
        CourseReader courseReader = new CourseReader("./data/noSuchFile.json");
        try {
            CourseStorage courseStorage = (CourseStorage) courseReader.read();
            fail("IOException expected");
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    void testReaderEmptyCourseStorage() {
        CourseReader courseReader = new CourseReader("./data/testWriterEmptyCourseStorage.json");
        try {
            CourseStorage courseStorage = (CourseStorage) courseReader.read();
            assertEquals(0,courseStorage.getCourseList().size());
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }

    @Test
    void testReaderCourseStorage() {
        CourseReader courseReader = new CourseReader("./data/testWriterCourseStorage.json");
        try {
            CourseStorage courseStorage = (CourseStorage) courseReader.read();
            assertEquals(2, courseStorage.getCourseList().size());
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }
}