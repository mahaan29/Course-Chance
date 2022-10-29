package persistence;

import model.Course;
import model.exceptions.DuplicateCourseException;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import model.CourseStorage;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

class JsonCourseWriterTest {

    @Test
    public void testWriterInvalidFile() {
        try {
            CourseWriter courseWriter = new CourseWriter("./data/my\0illegal:fileName.json");
            courseWriter.open();
            fail("IOException was expected");
        } catch (IOException e) {
            // expected
        }
    }

    @Test
    public void testWriterEmptyCourseStorage() {
        try {
            CourseStorage courseStorage = new CourseStorage();
            CourseWriter courseWriter = new CourseWriter("./data/testWriterEmptyCourseStorage.json");
            courseWriter.open();
            courseWriter.write(courseStorage);
            courseWriter.close();
            CourseReader courseReader = new CourseReader("./data/testWriterEmptyCourseStorage.json");
            CourseStorage courseStorage1;
            courseStorage1 = (CourseStorage) courseReader.read();
            assertEquals(0, courseStorage1.getCourseList().size());
        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }

    @Test
    void testWriterCourseStorage() {
        try {
            CourseStorage courseStorage = new CourseStorage();
            Course course1 = new Course("CPSC 210", 4, 4, 1);
            Course course2 = new Course("CPSC 121", 3, 4, 1);
            assertEquals(0, courseStorage.getCourseList().size());
            try {
                courseStorage.addCourse(course1);
            } catch( DuplicateCourseException e) {
                //expected
            }

            try {
                courseStorage.addCourse(course2);
            } catch( DuplicateCourseException e) {
                //expected
            }

            assertEquals(2,courseStorage.getCourseList().size());
            CourseWriter courseWriter = new CourseWriter("./data/testWriterCourseStorage.json");
            courseWriter.open();
            courseWriter.write(courseStorage);
            courseWriter.close();
            CourseReader courseReader = new CourseReader("./data/testWriterCourseStorage.json");
            CourseStorage courseStorage1 = (CourseStorage) courseReader.read();
            assertEquals(2,courseStorage1.getCourseList().size());
        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }
}