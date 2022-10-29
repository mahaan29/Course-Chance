package persistence;

import model.Course;
import model.Student;
import model.StudentAuthentication;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class JsonStudentWriterTest {

    @Test
    public void testWriterInvalidFile() {
        try {
            StudentWriter studentWriter = new StudentWriter("./data/my\0illegal:fileName.json");
            studentWriter.open();
            fail("IOException was expected");
        } catch (IOException e) {
            // expected
        }
    }

    @Test
    public void testWriterEmptyStudentAuthentication() {
        try {
            StudentAuthentication studentAuthentication = new StudentAuthentication();
            StudentWriter studentWriter = new StudentWriter("./data/testWriterEmptyStudentAuthentication.json");
            studentWriter.open();
            studentWriter.write(studentAuthentication);
            studentWriter.close();
            StudentReader studentReader = new StudentReader("./data/testWriterEmptyStudentAuthentication.json");
            StudentAuthentication studentAuthentication1;
            studentAuthentication1 = (StudentAuthentication) studentReader.read();
            assertEquals(0, studentAuthentication1.getStudentList().size());
        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }

    @Test
    void testWriterStudentAuthentication() {
        try {
            StudentAuthentication studentAuthentication = new StudentAuthentication();
            Student student1 = new Student("testStudent1","testemail1","testpass1");
            Student student2 = new Student("testStudent2","testemail2","testpass2");
            Course course1 = new Course("CPSC 210", 4, 4, 1);
            Course course2 = new Course("CPSC 121", 3, 4, 1);
            student1.setCourseRegistered(course1);
            student1.setCourseRegistered(course2);
            assertEquals("CPSC 210", course1.getCourseName());
            assertEquals("CPSC 121", course2.getCourseName());
            assertEquals(2,student1.getCourseRegistered().size());
            student2.setCourseRegistered(course1);
            assertEquals(1,student2.getCourseRegistered().size());
            assertEquals(0, studentAuthentication.getStudentList().size());
            studentAuthentication.newStudent(student1);
            studentAuthentication.newStudent(student2);
            assertEquals(2, studentAuthentication.getStudentList().size());
            StudentWriter studentWriter = new StudentWriter("./data/testWriterStudentAuthentication.json");
            studentWriter.open();
            studentWriter.write(studentAuthentication);
            studentWriter.close();
            StudentReader studentReader = new StudentReader("./data/testWriterStudentAuthentication.json");
            StudentAuthentication studentAuthentication1 = studentReader.read();
            assertEquals(2,studentAuthentication1.getStudentList().size());
            assertEquals("CPSC 210", studentAuthentication1.getStudentList().get(0).getCourseRegistered().get(0).getCourseName());
            assertEquals("CPSC 121", studentAuthentication1.getStudentList().get(0).getCourseRegistered().get(1).getCourseName());
        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }
}