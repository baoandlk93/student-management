package com.codegym.studentmanagement.repository;

import com.codegym.studentmanagement.entity.Classes;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface IClassesRepository extends JpaRepository<Classes, UUID> {
}
