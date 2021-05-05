package com.example.demo.service;

import com.example.demo.converter.PersonConverter;
import com.example.demo.person.dao.PersonReponsitory;
import com.example.demo.dto.PersonDTO;
import com.example.demo.entity.person.PersonEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional("personTransactionManager")
public class PersonService implements IPersonService {
    @Autowired
    private PersonReponsitory personReponsitory;

    @Autowired
    private PersonConverter personConverter;

    @Override
    public List<PersonDTO> getAll() {
        List<PersonDTO> result = new ArrayList<>();
        List<PersonEntity> list1 = personReponsitory.findAll();
        for (PersonEntity item : list1) {
            PersonDTO personDTO = personConverter.toDTO(item);
            result.add(personDTO);
        }
        return result;
    }

    @Override
    public PersonDTO findById(int id) {
        PersonEntity personEntity = personReponsitory.findById(id);
        return personConverter.toDTO(personEntity);
    }

    @Override
    public PersonDTO save(PersonDTO personDTO) {
        PersonEntity personEntity;
        if (personDTO.getId() != 0) {
            PersonEntity oldPersonEntity = personReponsitory.findById(personDTO.getId());
            personEntity = personConverter.toEntity(personDTO, oldPersonEntity);
        } else
            personEntity = personConverter.toEntity(personDTO);

        personEntity = personReponsitory.save(personEntity);
        return personDTO;
    }


}
