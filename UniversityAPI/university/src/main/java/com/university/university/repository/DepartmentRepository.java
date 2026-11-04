package com.university.university.repository;
import com.university.university.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
public interface DepartmentRepository extends JpaRepository<Department, Integer> {}
