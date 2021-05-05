package com.example.demo.api;

import com.example.demo.dto.StudentDTO;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping("/get/students")
    public ResponseEntity<List<StudentDTO>> getStudents(){
        List<StudentDTO> listStudent = new ArrayList<>();
        listStudent = studentService.getAll();
        return new ResponseEntity<>(listStudent, HttpStatus.OK);
    }
}
