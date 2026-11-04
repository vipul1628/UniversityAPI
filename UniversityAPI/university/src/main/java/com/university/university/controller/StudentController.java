package com.university.university.controller;
import com.university.university.entity.Student;
import com.university.university.repository.StudentRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/api/students")
public class StudentController extends CrudController<Student, Integer> {
    public StudentController(StudentRepository repo) { super(repo, Integer::valueOf, Student::setStudentId); }
}
