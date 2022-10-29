package model;

import model.exceptions.DuplicateCourseException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CourseStorageTest {
    Course course1;
    Course course2;
    Student student1;
    Student student2;
    CourseStorage courseStorage;
    StudentAuthentication studentAuthentication;

    @BeforeEach
    public void setup() {
        course1 = new Course("CPSC 121", 4, 4, 0);
        course2 = new Course("CPSC 210", 3, 3, 0);

        student1 = new Student("testStudent1","student1@student.ubc.ca","student1@123");
        student2 = new Student("testStudent2","student2@student.ubc.ca","student2@123");

        courseStorage = new CourseStorage();
        studentAuthentication = new StudentAuthentication();
        boolean a = studentAuthentication.newStudent(student1);
        boolean b = studentAuthentication.newStudent(student2);
    }

    @Test
    public void testAddCourse() {

        try {
            courseStorage.addCourse(course1);
        } catch(DuplicateCourseException e) {
            fail();
        }

        try {
            courseStorage.addCourse(course1);
        } catch (DuplicateCourseException e) {
            //expected
        }

    }

    @Test
    public void testDeleteCourse() {

        try {
            courseStorage.addCourse(course1);
            courseStorage.addCourse(course2);
        } catch(DuplicateCourseException e) {
            fail();
        }


        student1.setCourseRegistered(course1);
        student2.setCourseRegistered(course1);

        assertEquals(1, student1.getCourseRegistered().size());
        assertEquals(1, student2.getCourseRegistered().size());

        assertTrue(courseStorage.deleteCourse("CPSC 121"));
        assertFalse(courseStorage.deleteCourse("CPSC 121"));

        assertFalse(courseStorage.deleteCourse("CPSC 213"));

        assertTrue(courseStorage.deleteCourse(0));

        assertEquals(0, student1.getCourseRegistered().size());
        assertEquals(0, student2.getCourseRegistered().size());


    }
    @Test
    public void testRegisterCourse() {

        try {
            courseStorage.addCourse(course1);
            courseStorage.addCourse(course2);
        } catch(DuplicateCourseException e) {
            //expected
        }

        assertEquals(1, courseStorage.getCourseList().size());
        assertEquals(0, courseStorage.registerCourse("CPSC 121", student1));
        assertEquals(1, courseStorage.registerCourse("CPSC 121", student1));
        assertEquals(2, courseStorage.registerCourse("CPSC 123", student1));
        CourseStorage courseStorage1 = new CourseStorage();
        courseStorage1.copyCourseList(courseStorage1.getCourseList());
        assertEquals(1,courseStorage1.getCourseList().size());

    }

    @Test
    public void testUnregisterCourse() {

        try {
            courseStorage.addCourse(course1);
            courseStorage.addCourse(course2);
        } catch(DuplicateCourseException e) {
            //expected
        }

        assertEquals(1, courseStorage.getCourseList().size());

        assertEquals(0, courseStorage.registerCourse("CPSC 121", student1));
        assertEquals(1, courseStorage.registerCourse("CPSC 121", student1));
        assertEquals(2, courseStorage.registerCourse("CPSC 123", student1));
        assertFalse(courseStorage.unregisterCourse("CPSC 221", student1));

        assertTrue(courseStorage.unregisterCourse("CPSC 121", student1));
        assertFalse(courseStorage.unregisterCourse("CPSC 121", student1));


    }

}