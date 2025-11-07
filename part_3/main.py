from student import Student

def find_student_by_id(students, student_id):
    for s in students:
        if s.get_student_id() == student_id:
            return s
    return None

def main():
    students = []

    is_running = True
    while is_running:
        print("\n---Student Enrollment System --- \n"
            "1. Add a new Student \n" +
            "2. Register Student for a program \n" +
            "3. Check a students GPA \n" +
            "4. Check a students Course Count \n" +
            "5. View a Students Details \n" +
            "6. List All Students \n" +
            "7. Exit Application"
            )
        selection = input("Please enter your selection (number): ")

        if selection == "1":
            first_name = input("Please enter student's first name: ").strip()
            last_name = input("Please enter student's last name: ").strip()
            dob = input("Please enter student's date of birth (YYYY-MM-DD): ").strip()
            gender = input("Please enter student's gender: ").strip()

            if not first_name or not last_name or not dob or not gender:
                print("One or more fields were empty. Please try again!")
                continue

            new_student = Student(first_name, last_name, dob, gender)
            students.append(new_student)
            print("Student has been successfully added!")
            print(str(new_student))

        elif selection == "2":
            id_number = input("Enter Student ID to register for a program: ").strip()
            if not id_number:
                print("No Student ID entered.")
                continue

            if not id_number.isdigit():
                print("Invalid Student ID entered.")
                continue

            id_int = int(id_number)
            if id_int < 0:
                print("Invalid Student ID. Must be >= 0.")
                continue

            found_student = find_student_by_id(students, id_int)
            if not found_student:
                print("Student not found.")
                continue

            program_name = input("Please enter the program's name: ").strip()
            current_semester = input("Please enter current semester: ").strip()
            course_count_input = input("Please enter number of courses enrolled: ").strip()

            if not program_name or not current_semester or not course_count_input:
                print("All fields must be entered.")
                continue

            try:
                int_course_count = int(course_count_input)
            except ValueError:
                print("Invalid course count. Must be a number.")
                continue

            if int_course_count < 0:
                print("Course count must be >= 0.")
                continue

            found_student.set_program(program_name)
            found_student.set_current_semester(current_semester)
            found_student.set_num_courses(int_course_count)
            print(f"Student with ID {id_int} successfully registered to {program_name} in {current_semester} with {int_course_count} courses.")

        elif selection == "3":
            id_number = input("Enter Student ID to check GPA: ").strip()
            if not id_number or not id_number.isdigit():
                print("Invalid Student ID.")
                continue

            id_int = int(id_number)
            found_student = find_student_by_id(students, id_int)
            if not found_student:
                print("Student not found.")
                continue

            print("Displaying Student GPA:")
            print(f"{found_student.get_gpa():.2f}")

        elif selection == "4":
            id_number = input("Enter Student ID to view Course Count: ").strip()
            if not id_number or not id_number.isdigit():
                print("Invalid Student ID.")
                continue

            id_int = int(id_number)
            found_student = find_student_by_id(students, id_int)
            if not found_student:
                print("Student not found.")
                continue

            print("Displaying Course Count:")
            print(str(found_student.get_num_courses()))

        elif selection == "5":
            id_number = input("Please enter a Student ID to view details: ").strip()
            if not id_number or not id_number.isdigit():
                print("Invalid Student ID.")
                continue

            id_int = int(id_number)
            found_student = find_student_by_id(students, id_int)
            if not found_student:
                print("Student not found.")
                continue

            print("Displaying Student Information:")
            print(str(found_student))

        elif selection == "6":
            if not students:
                print("There are no students to display.")
            else:
                print("Printing all students:")
                for s in students:
                    print(str(s))

        elif selection == "7":
            print("Exiting Program. Have a nice day!")
            is_running = False

        else:
            print("Invalid choice. Please enter a number between 1 and 7.")


if __name__ == "__main__":
    main()
