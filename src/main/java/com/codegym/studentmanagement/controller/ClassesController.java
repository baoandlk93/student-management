package com.codegym.studentmanagement.controller;

import com.codegym.studentmanagement.entity.Classes;
import com.codegym.studentmanagement.service.IClassesService;
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
@RequestMapping("/api/classes")
@AllArgsConstructor
public class ClassesController {
    private final IClassesService classesService;

    @PostMapping
    public ResponseEntity<String> save(@RequestBody Classes classes) {
        classesService.save(classes);
        return ResponseEntity.ok("Thêm lớp học thành công");
    }

    @GetMapping
    public ResponseEntity<List<Classes>> findAll() {
        return ResponseEntity.ok(classesService.findAll());
    }

    @GetMapping("/{classId}")
    public ResponseEntity<Classes> findById(@PathVariable("classId") UUID id) {
        return ResponseEntity.ok(classesService.findById(id));
    }
}
