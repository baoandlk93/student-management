package com.codegym.studentmanagement.entity;

import com.codegym.studentmanagement.entity.person.Student;
import com.codegym.studentmanagement.entity.person.Teacher;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;
import java.util.UUID;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Classes {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String name;
    private String description;

    @OneToMany(targetEntity = Course.class, mappedBy = "classes")
    private Set<Course> course;

    @OneToMany(targetEntity = Student.class,mappedBy = "classes")
    private Set<Student> students;

}
