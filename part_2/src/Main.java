import java.util.*;


// OPTIONAL CONSOLE TEXT COLOURS
  public static final String ANSI_RESET = "\u001B[0m";
  public static final String ANSI_RED = "\u001B[31m";
  public static final String ANSI_GREEN = "\u001B[32m";
  public static final String ANSI_YELLOW = "\u001B[33m";

void main() {
  
  Scanner scanner = new Scanner(System.in);

  // temp data 
  Student student = new Student( "John", "Snow", "2002-04-09", "male");
  System.out.println(student.toString());

  // initialize student list
  List<Student> students = new ArrayList<>();
  students.add(student);

  // main loop
  boolean is_running = true;
  while (is_running) {
    String id_number;
    int id_int;
    Student found_student;

    // blank line for readability
    System.out.println("");
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

    is_running = true;

    switch (selection) {
      // Add new Student 
      case "1":
        System.out.print("Please enter students first name: ");
        String first_name = scanner.nextLine();
        System.out.print("Please enter students last name: ");
        String last_name = scanner.nextLine();
        System.out.print("Please enter students date of birth (YYYY-MM-DD): ");
        String dob_input = scanner.nextLine();
        System.out.print("Please enter students gender: ");
        String gender = scanner.nextLine();

        // early exit for empty fields
        if (first_name.isEmpty() || last_name.isEmpty() || dob_input.isEmpty() || gender.isEmpty()) {
          System.out.println(ANSI_RED + "One or more of the inputted fields we empty.... please try again" + ANSI_RESET);
          break;
        } 
        // pass early exit check
        else {
          Student new_student = new Student(first_name, last_name, dob_input, gender);
          students.add(new_student);
          System.out.println(ANSI_GREEN + "Student has been successfully added" + ANSI_RESET);
        }
        break;
      case "4":
        System.out.print("Enter Students ID number to view Course Count: ");
        id_number = scanner.nextLine();

        // check if input has a number 
        if (id_number.isEmpty()) {
          System.out.println(ANSI_RED + "No Student ID entered.... Please enter an ID number." + ANSI_RESET);
          break;
        }
        
        // try to convert to integer
        try {
          id_int = Integer.parseInt(id_number);
        } catch (NumberFormatException e) {
          System.out.println(ANSI_RED + "Invalid Student ID entered.... Please enter a valid ID number." + ANSI_RESET);
          break;
        }

        // check if number is negative
        if (id_int < 0) {
          System.out.println(ANSI_RED + "Please enter a valid student ID Number (greater than or equal to 0)" + ANSI_RESET);
          break;
        } else {
          found_student = FindStudentById(students, id_int);
          if (found_student == null) {
            System.out.println(ANSI_RED + "Student with provided ID was not found..." + ANSI_RESET);
          } else {
            System.out.println("Displaying Student Information: ");
            System.out.println(ANSI_GREEN + found_student.getNumCourses() + ANSI_RESET);
          }
        }

        break;
      case "5":
        System.out.print("Please enter a Student ID to view details: ");
        id_number = scanner.nextLine();

        // check if input has a number 
        if (id_number.isEmpty()) {
          System.out.println(ANSI_RED + "No Student ID entered.... Please enter an ID number." + ANSI_RESET);
          break;
        }
        
        // try to convert to integer
        try {
          id_int = Integer.parseInt(id_number);
        } catch (NumberFormatException e) {
          System.out.println(ANSI_RED + "Invalid Student ID entered.... Please enter a valid ID number." + ANSI_RESET);
          break;
        }

        // check if number is negative
        if (id_int < 0) {
          System.out.println(ANSI_RED + "Please enter a valid student ID Number (greater than or equal to 0)" + ANSI_RESET);
          break;
        } else {
          found_student = FindStudentById(students, id_int);
          if (found_student == null) {
            System.out.println(ANSI_RED + "Student with provided ID was not found..." + ANSI_RESET);
          } else {
            System.out.println("Displaying Student Information: ");
            System.out.println(ANSI_GREEN + found_student.toString() + ANSI_RESET);
          }
        }
        break;
      case "6":
        if (students.size() == 0) {
          System.out.println(ANSI_RED + "There are no students to display....." + ANSI_RESET);
        } else {
          // print all students
          System.out.println("Printing all students in the system: ");
          for (Student s : students) {
            System.out.println(ANSI_GREEN + s.toString() + ANSI_RESET);
          }
        }
        break;  
      case "7":
        // turn off while loop
        is_running = false;
        System.out.println("Exiting Program. Goodbye!");
        break;
      default:
        System.out.println(ANSI_RED + "Invalid Choice. Please enter a number between 1 and 7." + ANSI_RESET);
        break;
    }
  }
  scanner.close();
}

public static Student FindStudentById(List<Student> list, int id) {
  for (Student s : list) {
    if (s.getStudentId() == id) {
      return s; // Return found student
    }
  }
  return null; // Return NULL if no student was found
}