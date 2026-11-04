package com.university.university.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "student")
public class Student {
    @Id @Column(name = "student_id") private Integer studentId;
    @Column(nullable = false, length = 50) private String name;
    @Column(length = 50) private String city;
    @Column(name = "admission_year") private Integer admissionYear;
    @Column(precision = 3, scale = 2) private BigDecimal cgpa;
    @ManyToOne @JoinColumn(name = "dept_id") private Department department;
    public Student() {}
    public Integer getStudentId() { return studentId; }
    public void setStudentId(Integer studentId) { this.studentId = studentId; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getCity() { return city; }
    public void setCity(String city) { this.city = city; }
    public Integer getAdmissionYear() { return admissionYear; }
    public void setAdmissionYear(Integer admissionYear) { this.admissionYear = admissionYear; }
    public BigDecimal getCgpa() { return cgpa; }
    public void setCgpa(BigDecimal cgpa) { this.cgpa = cgpa; }
    public Department getDepartment() { return department; }
    public void setDepartment(Department department) { this.department = department; }
}
