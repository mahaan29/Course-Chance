package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class StudentTest {

    Student student1;
    Student student2;
    Course course1;
    Course course2;

    @BeforeEach
    public void setup() {
        student1 = new Student("testStudent1","student1@student.ubc.ca","student1@123");
        student2 = new Student("testStudent2","student2@student.ubc.ca","student2@123");

        course1 = new Course("CPSC 121", 4, 4, 0);
        course2 = new Course("CPSC 210", 3, 3, 0);
    }

    @Test
    public void testStudentGetters() {
        assertEquals("testStudent1",student1.getName());
        assertEquals("testStudent2",student2.getName());

        assertEquals("student1@student.ubc.ca",student1.getEmail());
        assertEquals("student2@student.ubc.ca",student2.getEmail());

        assertEquals("student1@123",student1.getPassword());
        assertEquals("student2@123",student2.getPassword());

        assertEquals("testStudent1",student1.getName());
        assertEquals("testStudent2",student2.getName());
    }

    @Test
    public void testCourseRegistered() {
        assertEquals(0, student1.getCourseRegistered().size());
        assertEquals(0, student2.getCourseRegistered().size());

        student1.setCourseRegistered(course1);
        student1.setCourseRegistered(course2);

        student2.setCourseRegistered(course1);

        assertEquals(2, student1.getCourseRegistered().size());
        assertEquals(1, student2.getCourseRegistered().size());

        student1.deregisterCourse(course1.getCourseName());
        student2.deregisterCourse(course1.getCourseName());

        assertEquals(1, student1.getCourseRegistered().size());
        assertEquals(0, student2.getCourseRegistered().size());

        Student student3 = new Student("testname3","testemail3","testpass3");
        student3.copyCourseList(student1.getCourseRegistered());
        assertEquals(1,student3.getCourseRegistered().size());
    }
}