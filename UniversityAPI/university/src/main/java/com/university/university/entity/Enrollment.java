package com.university.university.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "enrollment")
public class Enrollment {
    @EmbeddedId private EnrollmentId id;
    private Integer marks;
    @Column(precision = 5, scale = 2) private BigDecimal attendance;
    @ManyToOne @MapsId("studentId") @JoinColumn(name = "student_id") private Student student;
    @ManyToOne @MapsId("courseId") @JoinColumn(name = "course_id") private Course course;
    public Enrollment() {}
    public EnrollmentId getId() { return id; }
    public void setId(EnrollmentId id) { this.id = id; }
    public Integer getMarks() { return marks; }
    public void setMarks(Integer marks) { this.marks = marks; }
    public BigDecimal getAttendance() { return attendance; }
    public void setAttendance(BigDecimal attendance) { this.attendance = attendance; }
    public Student getStudent() { return student; }
    public void setStudent(Student student) { this.student = student; }
    public Course getCourse() { return course; }
    public void setCourse(Course course) { this.course = course; }
}
