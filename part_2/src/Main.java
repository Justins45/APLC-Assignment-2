import java.util.*;
import java.time.*;


// OPTIONAL CONSOLE TEXT COLOURS
  public static final String ANSI_RESET = "\u001B[0m";
  public static final String ANSI_RED = "\u001B[31m";
  public static final String ANSI_GREEN = "\u001B[32m";
  public static final String ANSI_YELLOW = "\u001B[33m";

void main() {
  
  Scanner scanner = new Scanner(System.in);

  // temp data 
  LocalDate dob = LocalDate.of(2002,4,9);
  Student student = new Student(1001, "John", "Snow", dob, "male");
  System.out.println(student.toString());

  // initialize student list
  List<Student> students = new ArrayList<>();
  students.add(student);

  // main loop
  boolean is_running = true;
  while (is_running) {
    String id_number;
    int id_int;
    boolean try_convert;
    Student found_student;

    System.out.println(ANSI_YELLOW + 
      "--- Student Enrollment System --- \n" +
      "1. Add a new Student \n" + 
      "2. Register Student for a program \n" +
      "3. Check a students GPA \n" +
      "4. Check a students Course Count \n" +
      "5. View a Students Details \n" +
      "6. List All Students \n" +
      "7. Exit Application");
    System.out.print("Please enter your selection (number): " + ANSI_RESET);
    String selection = scanner.nextLine();

    System.out.println(selection);

    is_running = false;
  }
}

public static Student FindStudentById(List<Student> list, int studentId) {
  for (Student student : list) {
    if (student.getStudentId() == studentId) {
      return student; // Return the found student object
    }
  }
  return null; // Return NULL if no student was found
}