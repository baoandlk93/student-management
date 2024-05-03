package com.codegym.studentmanagement.repository;

import com.codegym.studentmanagement.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ICourseRepository extends JpaRepository<Course, UUID> {
}
