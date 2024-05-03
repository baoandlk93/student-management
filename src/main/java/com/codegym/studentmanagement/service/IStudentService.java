package com.codegym.studentmanagement.service;

import com.codegym.studentmanagement.entity.person.Student;

import java.util.List;
import java.util.UUID;

public interface IStudentService extends CRUDService<Student> {
    void addCourse(UUID id, UUID studentId);

    void addCourses(UUID id, List<String> courses);
}
