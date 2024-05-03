package com.codegym.studentmanagement.payload.request;

import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
public class StudentCourseRequest {
    private List<String> courses;

}
