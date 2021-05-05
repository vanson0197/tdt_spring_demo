package com.example.demo.converter;

import com.example.demo.dto.StudentDTO;
import com.example.demo.entity.student.StudentEntity;
import org.springframework.stereotype.Component;

@Component
public class StudentConverter {
    public StudentDTO toDTO(StudentEntity studentEntity) {
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setName(studentEntity.getName());
        studentDTO.setAge(studentEntity.getAge());
        studentDTO.setId(studentEntity.getId());
        studentDTO.setAddress(studentEntity.getAddress());
        return studentDTO;
    }
}
