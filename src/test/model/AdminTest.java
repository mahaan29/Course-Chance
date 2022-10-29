package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AdminTest {

    Admin admin;

    @BeforeEach
    public void setup() {
       admin = new Admin();
    }

    @Test
    public void testAdminGetters() {

        assertEquals("Admin", admin.getName());
        assertEquals("admin@ubc.ca", admin.getEmail());
        assertEquals("admin", admin.getPassword());

    }

    @Test
    public void testCheckAdminLogin() {

        assertTrue(admin.checkLogin("admin@ubc.ca", "admin"));
        assertFalse(admin.checkLogin("admin@ubc.ca", "wrong"));
        assertFalse(admin.checkLogin("wrong@ubc.ca", "admin"));
        assertFalse(admin.checkLogin("wrong@ubc.ca", "wrong"));

    }
}