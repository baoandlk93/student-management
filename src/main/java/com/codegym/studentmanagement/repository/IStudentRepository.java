package com.codegym.studentmanagement.repository;

import com.codegym.studentmanagement.entity.person.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface IStudentRepository extends JpaRepository<Student, UUID> {
}
