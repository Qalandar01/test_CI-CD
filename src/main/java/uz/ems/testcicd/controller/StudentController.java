package uz.ems.testcicd.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import uz.ems.testcicd.model.Student;

import java.util.List;

@Controller
public class StudentController {

    @GetMapping("/students")
    public String students(Model model) {

        List<Student> students = List.of(
                new Student(1L, "Ali", 20),
                new Student(2L, "Vali", 21),
                new Student(3L, "Sardor", 22),
                new Student(4L, "Jasmin", 20),

                new Student(5L, "John", 23),
                new Student(6L, "Anna", 19),
                new Student(7L, "David", 22),
                new Student(8L, "Maria", 21),
                new Student(9L, "Leo", 20),
                new Student(10L, "Sophia", 24)
        );

        model.addAttribute("students", students);
        return "students"; // students.html
    }
}

