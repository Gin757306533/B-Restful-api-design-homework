package com.thoughtworks.capability.gtb.restfulapidesign.service;

import com.thoughtworks.capability.gtb.restfulapidesign.dto.Student;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

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

    public void deleteStudentById(String id){
        this.studentMap.remove(id);
    }

    public List<Student> getStudentListByGenderOrNull(String gender) {
        if(gender == null){
            return studentMap.values().stream().collect(Collectors.toList());
        }else{
            return studentMap.values().stream().filter(student ->
                    student.getGender().equals(gender))
                    .collect(Collectors.toList());
        }
    }

    public void updateStudentById(String id, Student student) {
        Student originStudent = studentMap.get(id);
        if(student.getGender() != null){
            originStudent.setGender(student.getGender());
        }
        if(student.getName() != null){
            originStudent.setName(student.getName());
        }
        if(student.getNote() != null){
            originStudent.setNote(student.getNote());
        }
    }
}
