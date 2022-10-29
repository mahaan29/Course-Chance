package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CourseTest {
    Course course1;
    Course course2;
    Course course3;

    @BeforeEach
    public void setup() {
        course1 = new Course("CPSC 121", 4, 4, 0);
        course2 = new Course("CPSC 210", 3, 3, 0);
        course3 = new Course("CPSC 221");
    }

    @Test
    public void testCourseGetters() {
        assertEquals("CPSC 121",course1.getCourseName());
        assertEquals("CPSC 210",course2.getCourseName());

        assertEquals(4, course1.getCourseSeats());
        assertEquals(3, course2.getCourseSeats());

        assertEquals(4, course1.getCourseCredits());
        assertEquals(3, course2.getCourseCredits());

        assertEquals(0, course1.getCounter());
        assertEquals(0, course2.getCounter());
    }

    @Test
    public void testIncrementDecrement() {
        assertEquals(0, course1.getCounter());

        course1.incrementCounter();
        assertEquals(1, course1.getCounter());

        course1.decrementCounter();
        assertEquals(0, course1.getCounter());
    }

    @Test
    public void testToString() {
        assertEquals("Name: CPSC 121 , Seats: 4 , Credits: 4", course1.toString());
    }

}