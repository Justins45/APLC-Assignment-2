import java.util.*;

// Student Class
public class Student {
    // --- Attributes ---
    private int studentId;
    private String  firstName;
    private String lastName;
    private Date dateOfBirth;
    private String gender;
    private double gpa;
    private String currentSemester;
    private String program;
    private int numCourses;

    // --- Constructor ---
    public Student(int newId, String newFirstName, String newLastName, Date newDob, String newGender){
        this.studentId = newId;
        this.firstName = newFirstName;
        this.lastName = newLastName;
        this.dateOfBirth = newDob;
        this.gender = newGender;
        this.gpa = 0.0;
        this.currentSemester = "Not Applicable";
        this.program = "undeclared";
        this.numCourses = 0;
    }

    // --- Getters ---
    public int getStudentId(){ return studentId; }
    public String getFirstName(){return firstName; }
    public String getLastName(){return lastName; }
    public String getFullName(){return firstName + " " + lastName; }
    public Date getDateOfBirth(){return dateOfBirth; }
    public String getGender(){return gender; }
    public double getGpa(){return gpa; }
    public String getCurrentSemester(){return currentSemester; }
    public String getProgram(){return program; }
    public int getNumCourses(){return numCourses; }

    // --- Setters (Mutators) ---
    public void setFirstName(String newFirstName){this.firstName = newFirstName; }
    public void setLastName(String newLastName){this.lastName = newLastName; }
    public void setDateOfBirth(Date newDob){this.dateOfBirth = newDob; }
    public void setGender(String newGender){this.gender = newGender; }
    public void setGpa(double newGpa){this.gpa = newGpa; }
    public void setCurrentSemester(String newCurrentSemester){this.currentSemester = newCurrentSemester; }
    public void setProgram(String newProgram){this.program = newProgram; }
    public void setNumCourses(int newNumCourses){this.numCourses = newNumCourses; }

    // --- To String Method ---
    @Override
    public String toString(){
        return "ID: " + studentId + ", Name: " + firstName + " " + lastName +  ", DOB: " + dateOfBirth + ", Gender: " + gender + ", Program: " + program + ", GPA: " + gpa + ", Semester: " + currentSemester + ", Courses: " + currentSemester;
    }



}