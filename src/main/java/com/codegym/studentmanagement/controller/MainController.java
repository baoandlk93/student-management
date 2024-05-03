package com.codegym.studentmanagement.controller;

import com.codegym.studentmanagement.entity.person.Student;
import com.codegym.studentmanagement.service.IStudentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping
@AllArgsConstructor
public class MainController {
    private final IStudentService studentService;

    @GetMapping
    public ModelAndView home() {
        return new ModelAndView("index");
    }

    @GetMapping("/table")
    public ModelAndView table() {
        ModelAndView modelAndView = new ModelAndView("table");
        modelAndView.addObject("students", studentService.findAll());
        return modelAndView;
    }

    @GetMapping("/login")
    public ModelAndView login() {
        return new ModelAndView("login");
    }
}
