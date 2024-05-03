package com.codegym.studentmanagement.repository;

import com.codegym.studentmanagement.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface IRoleRepository extends JpaRepository<Role, UUID> {
}
