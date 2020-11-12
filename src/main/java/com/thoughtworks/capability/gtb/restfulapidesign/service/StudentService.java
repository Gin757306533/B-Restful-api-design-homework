package com.thoughtworks.capability.gtb.restfulapidesign.service;

import com.thoughtworks.capability.gtb.restfulapidesign.dto.Student;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class StudentService {

    private Map<String, Student> studentMap;

    public StudentService() {
        this.studentMap = new HashMap<>();
    }

    public void createStudent(Student student){
        this.studentMap.put(student.getId(), student);
    }

    public Student getStudentById(String id){
        return this.studentMap.get(id);
    }
}
