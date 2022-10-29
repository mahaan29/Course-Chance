package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class StudentAuthenticationTest {

    Student student1;
    Student student2;
    Student student3;
    StudentAuthentication studentAuthentication;

    @BeforeEach
    public void setup() {


        student1 = new Student("testStudent3","student3@student.ubc.ca","student3@123");
        student2 = new Student("testStudent4","student4@student.ubc.ca","student4@123");
        student3 = new Student("Admin","admin@ubc.ca","admin");

        studentAuthentication = new StudentAuthentication();

    }

    @Test
    public void testNewStudent() {

        assertTrue(studentAuthentication.newStudent(student1));
        assertTrue(studentAuthentication.newStudent(student2));
        assertFalse(studentAuthentication.newStudent(student3));
        assertFalse(studentAuthentication.newStudent(student1));
        //assertEquals(4,studentAuthentication.getStudentList().size());
        StudentAuthentication studentAuthentication1 = new StudentAuthentication();
        studentAuthentication1.copyStudentList(studentAuthentication.getStudentList());

    }

    @Test
    public void testValidateStudent() {

        assertEquals(student1.getName(), studentAuthentication.validateStudent("student3@student.ubc.ca","student3@123").getName());
        assertEquals(null, studentAuthentication.validateStudent("student4@student.ubc.ca","student3@123"));
        assertEquals(null, studentAuthentication.validateStudent("student3@student.ubc.ca","student4@123"));
        assertEquals(null, studentAuthentication.validateStudent("student5@student.ubc.ca","student5@123"));

    }



}