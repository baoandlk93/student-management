package com.codegym.studentmanagement.controller;

import com.codegym.studentmanagement.entity.Course;
import com.codegym.studentmanagement.service.ICourseService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/course")
@AllArgsConstructor
public class CourseController {
    private final ICourseService courseService;

    @PostMapping
    public ResponseEntity<String> save(@RequestBody Course course) {
        courseService.save(course);
        return ResponseEntity.ok("Thêm môn học thành công");
    }

    @GetMapping
    public ResponseEntity<List<Course>> findAll() {
        List<Course> courses = courseService.findAll();
        return ResponseEntity.ok(courses);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Course> findById(@PathVariable UUID id) {
        Course course = courseService.findById(id);
        return ResponseEntity.ok(course);
    }
}
