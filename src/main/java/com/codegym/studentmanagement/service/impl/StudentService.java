package com.codegym.studentmanagement.service.impl;

import com.codegym.studentmanagement.entity.Course;
import com.codegym.studentmanagement.entity.person.Student;
import com.codegym.studentmanagement.repository.ICourseRepository;
import com.codegym.studentmanagement.repository.IStudentRepository;
import com.codegym.studentmanagement.service.IStudentService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Service
@AllArgsConstructor
@Transactional
public class StudentService implements IStudentService {
    private final IStudentRepository studentRepository;
    private final ICourseRepository courseRepository;

    @Override
    public Student findById(UUID id) {
        return studentRepository.findById(id).orElse(null);
    }

    @Override
    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public void save(Student student) {
        studentRepository.save(student);
    }

    @Override
    public void deleteById(UUID id) {

    }

    @Override
    public void addCourse(UUID id, UUID studentId) {
        try {
            Student student = studentRepository.findById(studentId).get();
            Set<Course> courses = new HashSet<>();
            courses.add(courseRepository.findById(id).orElse(null));
            student.setCourses(courses);
            studentRepository.save(student);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addCourses(UUID id, List<String> courses) {
        Student student = studentRepository.findById(id).get();
        Set<Course> courseSet = new HashSet<>();
        for (String course : courses) {
            courseSet.add(courseRepository.findById(UUID.fromString(course)).get());
        }
        student.setCourses(courseSet);
        studentRepository.save(student);
    }
}
