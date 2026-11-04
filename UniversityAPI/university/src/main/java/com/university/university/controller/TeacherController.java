package com.university.university.controller;
import com.university.university.entity.Teacher;
import com.university.university.repository.TeacherRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/api/teachers")
public class TeacherController extends CrudController<Teacher, Integer> {
    public TeacherController(TeacherRepository repo) { super(repo, Integer::valueOf, Teacher::setTeacherId); }
}
