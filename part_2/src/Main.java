import java.util.*;


// OPTIONAL CONSOLE TEXT COLOURS
  public static final String ANSI_RESET = "\u001B[0m";
  public static final String ANSI_RED = "\u001B[31m";
  public static final String ANSI_GREEN = "\u001B[32m";
  public static final String ANSI_YELLOW = "\u001B[33m";

void main() {
  
  // get Java scanner to allow for terminal inputs
  Scanner scanner = new Scanner(System.in);

  // initialize student list
  List<Student> students = new ArrayList<>();

  // main loop
  boolean isRunning = true;
  while (isRunning) {
    String idNumber;
    int idInt;
    Student foundStudent;

    // blank line for readability
    System.out.println("");
    // print main menu
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

    isRunning = true;
    switch (selection) {
      // Add new Student 
      case "1":
        System.out.print("Please enter students first name: ");
        String firstName = scanner.nextLine();
        System.out.print("Please enter students last name: ");
        String lastName = scanner.nextLine();
        System.out.print("Please enter students date of birth (YYYY-MM-DD): ");
        String dobInput = scanner.nextLine();
        System.out.print("Please enter students gender: ");
        String gender = scanner.nextLine();

        // early exit for empty fields
        if (firstName.isEmpty() || lastName.isEmpty() || dobInput.isEmpty() || gender.isEmpty()) {
          System.out.println(ANSI_RED + "One or more of the inputted fields we empty.... please try again!" + ANSI_RESET);
          break;
        } 
        // pass early exit check
        else {
          Student newStudent = new Student(firstName, lastName, dobInput, gender);
          students.add(newStudent);
          System.out.println("Student has been successfully added!");
          System.out.println(ANSI_GREEN + newStudent.toString() + ANSI_RESET);

        }
        break;
      case "2":
        System.out.print("Enter Student ID to register for a program: ");
        idNumber = scanner.nextLine();

         // check if input has a number 
        if (idNumber.isEmpty()) {
          System.out.println(ANSI_RED + "No Student ID entered.... Please enter an ID number." + ANSI_RESET);
          break;
        }
        
        // try to convert to integer
        try {
          idInt = Integer.parseInt(idNumber);
        } catch (NumberFormatException e) {
          System.out.println(ANSI_RED + "Invalid Student ID entered.... Please enter a valid ID number." + ANSI_RESET);
          break;
        }

        // check if number is negative
        if (idInt < 0) {
          System.out.println(ANSI_RED + "Please enter a valid student ID Number (greater than or equal to 0)." + ANSI_RESET);
          break;
        } else {
          foundStudent = FindStudentById(students, idInt);
          if (foundStudent == null) {
            System.out.println(ANSI_RED + "Student with provided ID was not found..." + ANSI_RESET);
          } else {
            // get program information 
            System.out.print("Please enter the programs name: ");
            String programName = scanner.nextLine();

            System.out.print("Please enter current semester: ");
            String currentSemester = scanner.nextLine();

            System.out.print("Please enter number of courses enrolled: ");
            String courseCountInput = scanner.nextLine();
            int intCourseCount;

            // try to convert to integer
            try {
              intCourseCount = Integer.parseInt(courseCountInput);
            } catch (NumberFormatException e) {
              System.out.println(ANSI_RED + "Invalid course count number entered... Please enter a valid course count number." + ANSI_RESET);
              break;
            }

            // check for empty fields
            if (programName.isEmpty() || currentSemester.isEmpty() || courseCountInput.isEmpty()) {
              System.out.println(ANSI_RED + "One or more of the inputted fields are empty... Please enter all fields." + ANSI_RESET);
              break;
            } 

            // check for positive number
            if (intCourseCount < 0) {
              System.out.println(ANSI_RED + "Please enter a valid course count (greater than or equal to 0)." + ANSI_RESET); 
              break;
            } else {
              // Pass all checks - register student for program
              foundStudent.setProgram(programName);
              foundStudent.setCurrentSemester(currentSemester);
              foundStudent.setNumCourses(intCourseCount);

              System.out.println(ANSI_GREEN + "Student with ID " + idInt + " has been successful registered to " + programName + " in " + currentSemester + " with " + intCourseCount + " courses." + ANSI_RESET);
            }
          }
        }
          

        break;
      case "3":
        System.out.print("Enter Students ID number to check GPA: ");
        idNumber = scanner.nextLine();
        
        // check if input has a number 
        if (idNumber.isEmpty()) {
          System.out.println(ANSI_RED + "No Student ID entered.... Please enter an ID number." + ANSI_RESET);
          break;
        }
        
        // try to convert to integer
        try {
          idInt = Integer.parseInt(idNumber);
        } catch (NumberFormatException e) {
          System.out.println(ANSI_RED + "Invalid Student ID entered.... Please enter a valid ID number." + ANSI_RESET);
          break;
        }

        // check if number is negative
        if (idInt < 0) {
          System.out.println(ANSI_RED + "Please enter a valid student ID Number (greater than or equal to 0)." + ANSI_RESET);
          break;
        } else {
          // locate Student
          foundStudent = FindStudentById(students, idInt);

          // early exit if no student found
          if (foundStudent == null) {
            System.out.println(ANSI_RED + "Student with provided ID was not found..." + ANSI_RESET);
          } else {
            // Display student GPA
            System.out.println("Displaying Student GPA with id of " + idInt + ": ");
            System.out.println(ANSI_GREEN + foundStudent.getGpa() + ANSI_RESET);
          }
        }

        break;
      case "4":
        System.out.print("Enter Students ID number to view Course Count: ");
        idNumber = scanner.nextLine();

        // check if input has a number 
        if (idNumber.isEmpty()) {
          System.out.println(ANSI_RED + "No Student ID entered.... Please enter an ID number." + ANSI_RESET);
          break;
        }
        
        // try to convert to integer
        try {
          idInt = Integer.parseInt(idNumber);
        } catch (NumberFormatException e) {
          System.out.println(ANSI_RED + "Invalid Student ID entered.... Please enter a valid ID number." + ANSI_RESET);
          break;
        }

        // check if number is negative
        if (idInt < 0) {
          System.out.println(ANSI_RED + "Please enter a valid student ID Number (greater than or equal to 0)." + ANSI_RESET);
          break;
        } else {
          // locate Student
          foundStudent = FindStudentById(students, idInt);

          // early exit if no student found
          if (foundStudent == null) {
            System.out.println(ANSI_RED + "Student with provided ID was not found..." + ANSI_RESET);
          } else {
            // Display student Course Count
            System.out.println("Displaying Student Course count with id of " + idInt + ": ");
            System.out.println(ANSI_GREEN + foundStudent.getNumCourses() + ANSI_RESET);
          }
        }

        break;
      case "5":
        System.out.print("Please enter a Student ID to view details: ");
        idNumber = scanner.nextLine();

        // check if input has a number 
        if (idNumber.isEmpty()) {
          System.out.println(ANSI_RED + "No Student ID entered.... Please enter an ID number." + ANSI_RESET);
          break;
        }
        
        // try to convert to integer
        try {
          idInt = Integer.parseInt(idNumber);
        } catch (NumberFormatException e) {
          System.out.println(ANSI_RED + "Invalid Student ID entered.... Please enter a valid ID number." + ANSI_RESET);
          break;
        }

        // check if number is negative
        if (idInt < 0) {
          System.out.println(ANSI_RED + "Please enter a valid student ID Number (greater than or equal to 0)." + ANSI_RESET);
          break;
        } else {
          // locate Student
          foundStudent = FindStudentById(students, idInt);

          // early exit if no student found
          if (foundStudent == null) {
            System.out.println(ANSI_RED + "Student with provided ID was not found..." + ANSI_RESET);
          } else {
            // Display student Details
            System.out.println("Displaying Student Information: ");
            System.out.println(ANSI_GREEN + foundStudent.toString() + ANSI_RESET);
          }
        }
        break;
      case "6":
        // check if there are any students to display
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
        isRunning = false;
        System.out.println("Exiting Program. Goodbye!");
        break;
      default:
        // invalid user input
        System.out.println(ANSI_RED + "Invalid Choice. Please enter a number between 1 and 7." + ANSI_RESET);
        break;
    }
  }
  // close scanner tool (prevents memory leaks)
  scanner.close();
}

// simple function to find student in list by ID number
public static Student FindStudentById(List<Student> list, int id) {
  for (Student s : list) {
    if (s.getStudentId() == id) {
      return s; // Return found student
    }
  }
  return null; // Return NULL if no student was found
}