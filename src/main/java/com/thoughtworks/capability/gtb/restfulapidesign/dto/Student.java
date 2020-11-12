package com.thoughtworks.capability.gtb.restfulapidesign.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    String id;
    String name;
    String gender;
    String note;
}
