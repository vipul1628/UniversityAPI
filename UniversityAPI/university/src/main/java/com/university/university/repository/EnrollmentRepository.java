package com.university.university.repository;
import com.university.university.entity.Enrollment;
import com.university.university.entity.EnrollmentId;
import org.springframework.data.jpa.repository.JpaRepository;
public interface EnrollmentRepository extends JpaRepository<Enrollment, EnrollmentId> {}
