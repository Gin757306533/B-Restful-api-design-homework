package com.thoughtworks.capability.gtb.restfulapidesign.service;

import com.thoughtworks.capability.gtb.restfulapidesign.dto.Student;
import com.thoughtworks.capability.gtb.restfulapidesign.dto.Team;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class StudentService {

    private Map<String, Student> studentMap;
    private int biggestStudentId;
    private Map<String, Team> teamMap;

    public StudentService() {
        this.studentMap = new HashMap<>();
        biggestStudentId = 0;
        this.teamMap = new HashMap<>();
        for(int index = 0; index< 6; index++){
            this.teamMap.put(String.valueOf(index+1),
                    Team.builder()
                    .id(String.valueOf(index+1))
                    .teamMembers(new ArrayList<>())
                    .build());
        }
    }

    public void createStudent(Student student){
        biggestStudentId += 1;
        student.setId(String.valueOf(biggestStudentId));
        this.studentMap.put(String.valueOf(biggestStudentId), student);
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

    public List<Team> getTeamList() {
        int teamIndex = 0;
        for(Student student: studentMap.values()){
            if(teamIndex == 6){
                teamIndex = 0;
            }
            teamMap.get(teamIndex).getTeamMembers().add(student);
        }
        return teamMap.values().stream().collect(Collectors.toList());
    }

    public void updateTeamName(String id, Team team) {
        if(team.getName() != null){
            this.teamMap.get(id).setName(team.getName());
        }
    }
}
