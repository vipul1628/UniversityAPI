package com.university.university.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "teaches")
public class Teaches {
    @EmbeddedId private TeachesId id;
    @ManyToOne @MapsId("teacherId") @JoinColumn(name = "teacher_id") private Teacher teacher;
    @ManyToOne @MapsId("courseId") @JoinColumn(name = "course_id") private Course course;
    public Teaches() {}
    public TeachesId getId() { return id; }
    public void setId(TeachesId id) { this.id = id; }
    public Teacher getTeacher() { return teacher; }
    public void setTeacher(Teacher teacher) { this.teacher = teacher; }
    public Course getCourse() { return course; }
    public void setCourse(Course course) { this.course = course; }
}
