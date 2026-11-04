package com.university.university.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "teacher")
public class Teacher {
    @Id @Column(name = "teacher_id") private Integer teacherId;
    @Column(nullable = false, length = 50) private String name;
    @Column(length = 50) private String designation;
    private Integer experience;
    @Column(precision = 10, scale = 2) private BigDecimal salary;
    @ManyToOne @JoinColumn(name = "dept_id") private Department department;
    public Teacher() {}
    public Integer getTeacherId() { return teacherId; }
    public void setTeacherId(Integer teacherId) { this.teacherId = teacherId; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getDesignation() { return designation; }
    public void setDesignation(String designation) { this.designation = designation; }
    public Integer getExperience() { return experience; }
    public void setExperience(Integer experience) { this.experience = experience; }
    public BigDecimal getSalary() { return salary; }
    public void setSalary(BigDecimal salary) { this.salary = salary; }
    public Department getDepartment() { return department; }
    public void setDepartment(Department department) { this.department = department; }
}
