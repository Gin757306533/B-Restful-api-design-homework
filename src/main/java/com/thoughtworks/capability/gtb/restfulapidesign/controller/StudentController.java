package com.thoughtworks.capability.gtb.restfulapidesign.controller;

import com.thoughtworks.capability.gtb.restfulapidesign.dto.Student;
import com.thoughtworks.capability.gtb.restfulapidesign.service.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @DeleteMapping("/students/{id}")
    public void deleteStudentById(@PathVariable String id){
        studentService.deleteStudentById(id);
    }

    @GetMapping("/students")
    public List<Student> getStudentListByGenderOrNull(@RequestParam(required = false) String gender){
        return studentService.getStudentListByGenderOrNull(gender);
    }
}
