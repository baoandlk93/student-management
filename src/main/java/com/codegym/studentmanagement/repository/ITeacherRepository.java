package com.codegym.studentmanagement.repository;

import com.codegym.studentmanagement.entity.person.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ITeacherRepository extends JpaRepository<Teacher, UUID> {
}
