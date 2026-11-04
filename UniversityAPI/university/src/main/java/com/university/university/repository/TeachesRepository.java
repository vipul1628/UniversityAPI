package com.university.university.repository;
import com.university.university.entity.Teaches;
import com.university.university.entity.TeachesId;
import org.springframework.data.jpa.repository.JpaRepository;
public interface TeachesRepository extends JpaRepository<Teaches, TeachesId> {}
