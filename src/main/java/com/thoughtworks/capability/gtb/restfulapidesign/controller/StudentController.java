package com.thoughtworks.capability.gtb.restfulapidesign.controller;

import com.thoughtworks.capability.gtb.restfulapidesign.dto.Student;
import com.thoughtworks.capability.gtb.restfulapidesign.dto.Team;
import com.thoughtworks.capability.gtb.restfulapidesign.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/students")
    @ResponseStatus(HttpStatus.CREATED)
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
    @ResponseStatus(HttpStatus.ACCEPTED)
    public List<Student> getStudentListByGenderOrNull(@RequestParam(required = false) String gender){
        return studentService.getStudentListByGenderOrNull(gender);
    }

    @PatchMapping("/students/{id}")
    public void updateStudentById(@PathVariable String id, @RequestBody Student student){
        studentService.updateStudentById(id, student);
    }

    @GetMapping("/teams")
    public List<Team> getTeamList(){
        return studentService.getTeamList();
    }

    @PatchMapping("/teams/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void updateTeamName(@PathVariable String id, @RequestBody Team team){
        studentService.updateTeamName(id, team);
    }
}
