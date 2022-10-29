package model;

import java.util.*;

// Admin class stores the basic information of the administrator who can:
//  - add/remove courses
//  - determine number of seats in a course
//  - determine number of credits of a course
// There is only a single administrator with pre-defined details (mentioned in README.md)
public class Admin extends Member {

    // Parametrized Constructor
    // MODIFIES: this
    public Admin() {
        this.name = "Admin";
        this.email = "admin@ubc.ca";
        this.password = "admin";
    }

    //Getter methods
    public String getName() {
        return this.name;
    }

    public String getEmail() {
        return this.email;
    }

    public String getPassword() {
        return this.password;
    }

    // EFFECTS: returns true if email and password matches; false otherwise
    public boolean checkLogin(String email, String password) {
        if (email.equals(this.email) && password.equals(this.password)) {
            return true;
        }
        return false;
    }

}
