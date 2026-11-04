package com.university.university.entity;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class TeachesId implements Serializable {
    @Column(name = "teacher_id") private Integer teacherId;
    @Column(name = "course_id") private Integer courseId;
    public TeachesId() {}
    public TeachesId(Integer teacherId, Integer courseId) { this.teacherId = teacherId; this.courseId = courseId; }
    public Integer getTeacherId() { return teacherId; }
    public void setTeacherId(Integer teacherId) { this.teacherId = teacherId; }
    public Integer getCourseId() { return courseId; }
    public void setCourseId(Integer courseId) { this.courseId = courseId; }
    @Override public boolean equals(Object o) { return o instanceof TeachesId that && Objects.equals(teacherId, that.teacherId) && Objects.equals(courseId, that.courseId); }
    @Override public int hashCode() { return Objects.hash(teacherId, courseId); }
}
