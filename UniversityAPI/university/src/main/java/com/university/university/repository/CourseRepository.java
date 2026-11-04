package com.university.university.repository;
import com.university.university.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
public interface CourseRepository extends JpaRepository<Course, Integer> {}
