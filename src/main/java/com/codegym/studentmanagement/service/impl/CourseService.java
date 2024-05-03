package com.codegym.studentmanagement.service.impl;

import com.codegym.studentmanagement.entity.Course;
import com.codegym.studentmanagement.repository.ICourseRepository;
import com.codegym.studentmanagement.service.ICourseService;
import com.codegym.studentmanagement.service.IStudentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class CourseService implements ICourseService {
    private final ICourseRepository courseRepository;

    @Override
    public Course findById(UUID id) {
        return courseRepository.findById(id).orElse(null);
    }

    @Override
    public List<Course> findAll() {
        return courseRepository.findAll();
    }

    @Override
    public void save(Course course) {
        courseRepository.save(course);
    }

    @Override
    public void deleteById(UUID id) {

    }
}
