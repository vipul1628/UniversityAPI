package com.university.university.controller;
import com.university.university.entity.Department;
import com.university.university.repository.DepartmentRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/api/departments")
public class DepartmentController extends CrudController<Department, Integer> {
    public DepartmentController(DepartmentRepository repo) { super(repo, Integer::valueOf, Department::setDeptId); }
}
