package com.example.demo.service;

import com.example.demo.converter.StudentConverter;
import com.example.demo.student.dao.StudentReponsitory;
import com.example.demo.dto.StudentDTO;
import com.example.demo.entity.student.StudentEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService implements IStudentService {
    @Autowired
    private StudentReponsitory studentReponsitory;

    @Autowired
    private StudentConverter studentConverter;



    @Override
    public List<StudentDTO> getAll() {
        List<StudentDTO> result = new ArrayList<>();
        List<StudentEntity> list1 = studentReponsitory.findAll();
        for(StudentEntity item : list1){
            StudentDTO studentDTO = studentConverter.toDTO(item);
            result.add(studentDTO);
        }
        return result;
    }
}
