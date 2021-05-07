package com.example.demo.api;


import com.example.demo.dto.PersonDTO;
import com.example.demo.exception.RecordNotFoundException;
import com.example.demo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import java.util.ArrayList;
import java.util.List;


@RestController
public class PersonController {

    @Autowired
    private PersonService personService;

    @GetMapping("/get/persons")
    public ResponseEntity<List<PersonDTO>> getPersons(@RequestParam(value = "page", required = false) Integer page,
                                                      @RequestParam(value = "limit", defaultValue = "3", required = false) Integer limit) {
        List<PersonDTO> result;
        if (page != null) {
            int page1 = page - 1;
            Pageable pageable = PageRequest.of(page1, limit);
            result = personService.getAll(pageable);
        } else
            result = personService.getAll();

        return new ResponseEntity<>(result, HttpStatus.OK);
    }


    @PostMapping("/post/person")
    public ResponseEntity<PersonDTO> addPersons(@Valid @RequestBody PersonDTO personDTO) {
        personService.save(personDTO);
        return new ResponseEntity(personDTO, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Integer> deletePerson(@PathVariable(value = "id") Integer id1) {
        PersonDTO personDTO = personService.findById(id1);
        if (personDTO.getId() == 0) {
            throw new RecordNotFoundException("Not found person with id = " + id1);
        } else
            personService.deleteById(id1);
        return new ResponseEntity<>(id1, HttpStatus.OK);
    }

    @PutMapping("/put/{id}")
    public ResponseEntity<PersonDTO> putPerSon(@PathVariable(value = "id") Integer id, @Valid @RequestBody PersonDTO personDTO) {
        PersonDTO personDTO1 = personService.findById(id);
        if (personDTO1.getId() == 0) {
            throw new RecordNotFoundException("Not found person with id = " + id);
        } else
            personDTO.setId(id);
        personService.save(personDTO);
        return new ResponseEntity<>(personDTO, HttpStatus.OK);
    }
}
