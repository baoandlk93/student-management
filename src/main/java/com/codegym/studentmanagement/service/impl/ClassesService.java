package com.codegym.studentmanagement.service.impl;

import com.codegym.studentmanagement.entity.Classes;
import com.codegym.studentmanagement.repository.IClassesRepository;
import com.codegym.studentmanagement.service.IClassesService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class ClassesService implements IClassesService {
    private final IClassesRepository classesRepository;

    @Override
    public Classes findById(UUID id) {
        return classesRepository.findById(id).orElse(null);
    }

    @Override
    public List<Classes> findAll() {
        return classesRepository.findAll();
    }

    @Override
    public void save(Classes classes) {
        classesRepository.save(classes);
    }

    @Override
    public void deleteById(UUID id) {

    }
}
