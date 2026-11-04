package com.university.university.controller;
import com.university.university.entity.Course;
import com.university.university.repository.CourseRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/api/courses")
public class CourseController extends CrudController<Course, Integer> {
    public CourseController(CourseRepository repo) { super(repo, Integer::valueOf, Course::setCourseId); }
}
