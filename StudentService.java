
package com.example.studentapi.service;

import com.example.studentapi.model.Student;
import com.example.studentapi.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class StudentService {

    private final StudentRepository repository;

    public StudentService(StudentRepository repository) {
        this.repository = repository;
    }

    public Student saveStudent(Student student) {
        return repository.save(student);
    }

    public List<Student> getAllStudents() {
        return repository.findAll();
    }

    public void updateAgeForAll() {
        List<Student> students = repository.findAll();
        for (Student student : students) {
            int age = calculateAge(student.getBirthYear(), student.getBirthMonth(), student.getBirthDay());
            student.setAge(age);
            repository.save(student);
        }
    }

    public List<Student> getStudentsByAgeRange(int min, int max) {
        return repository.findByAgeBetween(min, max);
    }

    private int calculateAge(int year, int month, int day) {
        return LocalDate.now().getYear() - year;
    }
}
