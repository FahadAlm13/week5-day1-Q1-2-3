package spring.boot.week5day1q1.Controller;

import org.springframework.web.bind.annotation.*;
import spring.boot.week5day1q1.Api.ApiStudent;
import spring.boot.week5day1q1.Model.Student;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/student")
public class StudentController {

    ArrayList<Student> students = new ArrayList<>();

    //GET
    @GetMapping("/get")
    public ArrayList<Student> getStudents() {
        return students;
    }

    // Post
    @PostMapping("/add")
    public ApiStudent addStudent(@RequestBody Student student) {
        try {
            this.students.add(student);
            return new ApiStudent("Success add student", "200");
        } catch (Exception e) {
            System.out.println("Error adding student");
        }
        return new ApiStudent("Failed to add new student", "400");
    }

    // update
    @PutMapping("/update/{index}")
    public ApiStudent updateStudent(@RequestBody Student student, @PathVariable int index) {
        try {
            students.set(index, student);
            return new ApiStudent("Success update student", "200");
        } catch (Exception e) {
            System.out.println("Error updating student");
        }
        return new ApiStudent("Failed to update student", "400");
    }

    // delete
    @DeleteMapping("/delete/{index}")
    public ApiStudent deleteStudent(@PathVariable int index) {
        try {
            students.remove(index);
            return new ApiStudent("Success delete student", "200");
        } catch (Exception e) {
            System.out.println("Error deleting student");
        }
        return new ApiStudent("Failed to delete student", "400");
    }

    //get name
    @GetMapping("/name/{index}")
    public String getStudentName(@PathVariable int index) {
        try {
            for (Student student : students) {
                if (student.getName().equals(students.get(index).getName())) {
                    return students.get(index).getName();
                }
            }
        } catch (Exception e) {
            System.out.println("Error in getStudentName: " + e.getMessage());
        }
        return null;
    }

    // get age
    @GetMapping("/age/{index}")
    public int getAge(@PathVariable int index) {
        try {
            for (Student student : students) {
                if (student.getAge() == (students.get(index).getAge())) {
                    return student.getAge();
                }
            }
        } catch (Exception e) {
            System.out.println("Error in getAge :" + e.getMessage());
        }
        return 0;
    }

    //degree
    @GetMapping("/degree/{index}")
    public String getStudentDegree(@PathVariable int index) {
        try {
            for (Student student : students) {
                if (student.getDegree().equals(students.get(index).getDegree())) {
                    return students.get(index).getDegree();
                }
            }
        } catch (Exception e) {
            System.out.println("Error in getStudentDegree: " + e.getMessage());
        }
        return null;
    }

    //status
    @GetMapping("/status/{index}")
    public String getStudentStatus(@PathVariable int index) {
        try {
            for (Student student : students) {
                if (student.getName().equals(students.get(index).getName())) {
                    return student.getStatus();
                }
            }
        } catch (Exception e) {
            System.out.println("Error in getStudentStatus: " + e.getMessage());
        }
        return null;
    }
}
