package com.codegym.studentmanagement.controller;

import com.codegym.studentmanagement.entity.person.Teacher;
import com.codegym.studentmanagement.service.ITeacherService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/teacher")
@AllArgsConstructor
public class TeacherController {
    private final ITeacherService teacherService;

    @PostMapping
    public ResponseEntity<String> save(Teacher teacher) {
        teacherService.save(teacher);
        return ResponseEntity.ok("Thêm giáo viên thành công");
    }

    @GetMapping
    public ResponseEntity<List<Teacher>> findAll() {
        return ResponseEntity.ok(teacherService.findAll());
    }
}
