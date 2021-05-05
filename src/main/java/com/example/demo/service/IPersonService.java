package com.example.demo.service;

import com.example.demo.dto.PersonDTO;

import java.util.List;


public interface IPersonService {
    List<PersonDTO> getAll();
}
