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
        for(PersonEntity item : list1){
            PersonDTO personDTO = personConverter.toDTO(item);
            result.add(personDTO);
        }
        return result;
    }
}
