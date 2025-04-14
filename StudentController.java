
package com.example.studentapi.controller;

import com.example.studentapi.model.Student;
import com.example.studentapi.service.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    private final StudentService service;

    public StudentController(StudentService service) {
        this.service = service;
    }

    @PostMapping
    public Student createStudent(@RequestBody Student student) {
        return service.saveStudent(student);
    }

    @GetMapping
    public List<Student> getAll() {
        return service.getAllStudents();
    }

    @PostMapping("/update-age")
    public void updateAgeForAllStudents() {
        service.updateAgeForAll();
    }

    @GetMapping("/age-range")
    public List<Student> getStudentsByAgeRange(
        @RequestParam int min,
        @RequestParam int max) {
        return service.getStudentsByAgeRange(min, max);
    }
}
