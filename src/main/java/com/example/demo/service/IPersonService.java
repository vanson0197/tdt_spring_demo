package com.example.demo.service;

import com.example.demo.dto.PersonDTO;
import org.springframework.data.domain.Pageable;

import java.util.List;


public interface IPersonService {
    List<PersonDTO> getAll();
    List<PersonDTO> getAll(Pageable pageable);
    PersonDTO findById(int id);
    PersonDTO save(PersonDTO personDTO);
    void deleteById(int id);
}
