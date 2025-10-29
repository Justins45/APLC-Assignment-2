class Student:
    _next_id = 1

    def __init__(self, last_name, first_name, dob, gender):
        self.student_id = Student._next_id
        Student._next_id += 1

        self.first_name = first_name
        self.last_name = last_name
        self.dob = dob
        self.gender = gender
        self.program = None
        self.current_semester = None
        self.num_courses = 0
        self.gpa = 0.0

        #setters

    def set_program(self, program):
        self.program = program

    def set_current_semester(self, semester):
        self.current_semester = semester

    def set_num_courses(self, count):
        self.num_courses = count

    def set_gpa(self, gpa):
        self.gpa = gpa

    def set_first_name(self, new_first_name):
        self.first_name = new_first_name

    def set_last_name(self, new_last_name):
        self.last_name = new_last_name

    def set_date_of_birth(self, new_dob):
        self.dob = new_dob

    def set_gender(self, new_gender):
        self.gender = new_gender

        #getters

    def get_num_courses(self):
        return self.num_courses

    def get_gpa(self):
        return self.gpa

    def get_gender(self):
        return self.gender

    def get_student_id(self):
        return self.student_id

    def get_current_semester(self):
        return self.current_semester

    def get_program(self):
        return self.program

    def get_first_name(self):
        return self.first_name

    def get_last_name(self):
        return self.last_name

    def get_full_name(self):
        return f"{self.first_name} {self.last_name}"

    def get_date_of_birth(self):
        return self.dob

    def __str__(self):
        return (
            f"ID: {self.student_id}, "
            f"Name: {self.first_name} {self.last_name}, "
            f"DOB: {self.dob}, "
            f"Gender: {self.gender}, "
            f"Program: {self.program}, "
            f"GPA: {self.gpa}, "
            f"Semester: {self.current_semester}, "
            f"Courses: {self.num_courses}"
        )

