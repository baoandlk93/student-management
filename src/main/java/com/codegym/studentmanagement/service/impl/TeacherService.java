package com.codegym.studentmanagement.service.impl;

import com.codegym.studentmanagement.entity.person.Teacher;
import com.codegym.studentmanagement.repository.ITeacherRepository;
import com.codegym.studentmanagement.service.ITeacherService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class TeacherService implements ITeacherService {
    private final ITeacherRepository teacherRepository;

    @Override
    public Teacher findById(UUID id) {
        return teacherRepository.findById(id).orElse(null);
    }

    @Override
    public List<Teacher> findAll() {
        return teacherRepository.findAll();
    }

    @Override
    public void save(Teacher teacher) {
        teacherRepository.save(teacher);
    }

    @Override
    public void deleteById(UUID id) {

    }
}
