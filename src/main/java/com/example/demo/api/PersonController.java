package com.example.demo.api;

import com.example.demo.dto.PersonDTO;
import com.example.demo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


@RestController
public class PersonController {

    @Autowired
    private PersonService personService;

    @GetMapping("/get/persons")
    public ResponseEntity<List<PersonDTO>> getPersons(){
        List<PersonDTO> listPerson = new ArrayList<>();
        listPerson = personService.getAll();
        return new ResponseEntity<>(listPerson, HttpStatus.OK);
    }


}
