import java.util.*;

// Student Class
class Student {
    // --- Attributes ---
    PRIVATE Int studentId
    PRIVATE String firstName
    PRIVATE String lastName
    PRIVATE Date dateOfBirth
    PRIVATE String gender
    PRIVATE Double gpa 
    PRIVATE String currentSemester
    PRIVATE String program
    PRIVATE Int numCourses

    // --- Constructor ---
Public Student(int newId, String newFirstName, String newLastName, Date newDob, String newGender, double initialGpa){
    this.studentId = newId;
    this.firstName = newFirstName;
    this.lastName = newLastName;
    this.dateOfBirth = newDob;
    this.gender = newGender;
    this.gpa = initialGpa;
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
public int getNumCourses(){return numCourses}

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
@override
public String toString(){
return "ID: " + studentId + ", Name: " + firstName + " " + lastName +
", DOB: " + dateOfBirth +
", Gender: " + gender + 
", Program: " + program
", GPA: " + gpa +
", Semester: " + currentSemester +
", Courses: " + currentSemester +
} 



}