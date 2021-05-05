package com.example.demo.service;

import com.example.demo.dto.StudentDTO;

import java.util.List;

public interface IStudentService {
    List<StudentDTO> getAll();
}
