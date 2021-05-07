package com.example.demo.converter;

import com.example.demo.dto.PersonDTO;
import com.example.demo.entity.mysql.PersonEntity;
import org.springframework.stereotype.Component;

@Component
public class PersonConverter {
    public PersonDTO toPersonDTO(PersonEntity personEntity) {
        PersonDTO personDTO = new PersonDTO();
        personDTO.setId(personEntity.getId());
        personDTO.setName(personEntity.getName());
        personDTO.setAge(personEntity.getAge());
        personDTO.setAddress(personEntity.getAddress());
        return personDTO;
    }

    public PersonEntity toPersonEntity(PersonDTO personDTO) {
        PersonEntity personEntity = new PersonEntity();
        personEntity.setName(personDTO.getName());
        personEntity.setAge(personDTO.getAge());
        personEntity.setAddress(personDTO.getAddress());
        return personEntity;
    }

    public PersonEntity toEntity(PersonDTO personDTO, PersonEntity personEntity) {
        personEntity.setName(personDTO.getName());
        personEntity.setAge(personDTO.getAge());
        personEntity.setAddress(personDTO.getAddress());
        return personEntity;
    }


}
