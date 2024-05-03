package com.codegym.studentmanagement.controller;

import com.codegym.studentmanagement.entity.person.Student;
import com.codegym.studentmanagement.payload.request.StudentCourseRequest;
import com.codegym.studentmanagement.service.IStudentService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/student")
@AllArgsConstructor
public class StudentController {
    private final IStudentService studentService;

    @PostMapping
    public ResponseEntity<String> save(@RequestBody Student student) {
        studentService.save(student);
        return ResponseEntity.ok("Thêm sinh viên thành công");
    }

    @GetMapping
    public ResponseEntity<List<Student>> findAll() {
        return ResponseEntity.ok(studentService.findAll());
    }

    @GetMapping("/{studentId}")
    public ResponseEntity<Student> findById(@PathVariable("studentId") UUID id) {
        return ResponseEntity.ok(studentService.findById(id));
    }

    @PostMapping("/{studentId}/{courseId}")
    public ResponseEntity<String> findByClassId(@PathVariable("courseId") UUID id,
                                                @PathVariable("studentId") UUID studentId) {
        studentService.addCourse(id, studentId);
        return ResponseEntity.ok("Success");
    }

    @PostMapping("/{id}/courses")
    public ResponseEntity<String> findAllByCourseId(@PathVariable("id") UUID id,
                                                    @RequestBody StudentCourseRequest request
    ) {
        studentService.addCourses(id, request.getCourses());
        return ResponseEntity.ok("Success");
    }
}
