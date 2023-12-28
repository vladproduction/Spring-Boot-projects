package com.vladproduction.controller;

import com.vladproduction.data.Student;
import com.vladproduction.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@AllArgsConstructor
public class MainController {

    private StudentService studentService;

    @RequestMapping("/hello/{color}")
    public String hello(@PathVariable String color, Model model){
        model.addAttribute("username", "Student");
        model.addAttribute("color", color);
        return "hello";
    }

    @PostMapping("/add_student")
    public String addStudent(@RequestParam String name, @RequestParam int age){
        studentService.addStudent(new Student(name, age));
        return "redirect:/students";
    }

    @GetMapping("/students")
    public String students(Model model){
        model.addAttribute(studentService.findAll());
        return "students";
    }

}
