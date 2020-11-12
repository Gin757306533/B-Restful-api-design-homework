package com.thoughtworks.capability.gtb.restfulapidesign.controller;

import com.thoughtworks.capability.gtb.restfulapidesign.dto.Student;
import com.thoughtworks.capability.gtb.restfulapidesign.service.StudentService;
import org.springframework.web.bind.annotation.*;

@RestController
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/students")
    public void createStudent(@RequestBody Student student){
        studentService.createStudent(student);
    }

    @GetMapping("/students/{id}")
    public Student getStudentById(@PathVariable String id){
        return studentService.getStudentById(id);
    }
}
