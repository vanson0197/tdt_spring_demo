package com.example.demo.converter;

import com.example.demo.dto.PersonDTO;
import com.example.demo.entity.person.PersonEntity;
import org.springframework.stereotype.Component;

@Component
public class PersonConverter {
    public PersonDTO toDTO(PersonEntity personEntity){
        PersonDTO personDTO = new PersonDTO();
        personDTO.setName(personEntity.getName());
        personDTO.setAge(personEntity.getAge());
        personDTO.setId(personEntity.getId());
        personDTO.setAddress(personEntity.getAddress());
        return  personDTO;
    }


}
