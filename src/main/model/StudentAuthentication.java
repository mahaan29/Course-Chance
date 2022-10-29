package model;

import org.json.JSONArray;
import org.json.JSONObject;
import persistence.Writable;

import java.util.ArrayList;
import java.util.List;

// StudentAuthentication stores information of registered students and administrator and validates login process
// of an user.
public class StudentAuthentication implements Writable {

    private Admin admin = new Admin();

    //studentList array stores the information of students registered on the portal.
    protected static List<Student> studentList = new ArrayList<>();

    // MODIFIES: studentList
    // EFFECTS: creates a new student profile
    public boolean newStudent(Student s) {
        if (admin.email.equals(s.getEmail())) {
            return false;
        }
        for (Student student : studentList) {
            if (student.getEmail().equals(s.getEmail())) {
                return false;
            }
        }
        studentList.add(s);
        return true;

    }

    //MODIFIES: this
    //EFFECTS: returns true if a student logs in successfully and stores the information.
    public Student validateStudent(String email, String password) {
        for (Student student : studentList) {
            if (student.getEmail().equals(email) && student.getPassword().equals(password)) {
                return student;
            }
        }
        return null;
    }

    // Getter methods
    public static List<Student> getStudentList() {
        return studentList;
    }

    public void copyStudentList(List<Student> students) {
        studentList = students;
    }

    // EFFECTS: Returns this class as a JSON Object
    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        JSONArray jsonArray = new JSONArray();
        for (Student s : studentList) {
            jsonArray.put(s.toJson());
        }
        json.put("studentList", jsonArray);
        return json;
    }
}
