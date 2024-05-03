package com.codegym.studentmanagement.repository;

import com.codegym.studentmanagement.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface IUserRepository extends JpaRepository<User, UUID> {
    User findByUsername(String username);

    @Query("SELECT r.name FROM User u " +
            "JOIN u.role r WHERE u.username = :username")
    List<String> findRoleByUsername(String username);
}
