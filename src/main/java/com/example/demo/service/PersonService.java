package com.example.demo.service;

import com.example.demo.converter.PersonConverter;
import com.example.demo.person.dao.PersonReponsitory;
import com.example.demo.dto.PersonDTO;
import com.example.demo.entity.person.PersonEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import org.springframework.data.domain.Pageable;
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
    public List<PersonDTO> getAll(Pageable pageable) {
         List<PersonDTO> result = new ArrayList<>();
         List<PersonEntity> list1 = personReponsitory.findAll(pageable).getContent();
         for(PersonEntity personEntity: list1){
             PersonDTO personDTO = personConverter.toDTO(personEntity);
             result.add(personDTO);
         }
         return result;
    }

    @Override
    public PersonDTO findById(int id) {
        PersonEntity personEntity = personReponsitory.findById(id);
        if(personEntity != null){
            return personConverter.toDTO(personEntity);
        }else
            return new PersonDTO();
    }

    @Override
    public PersonDTO save(PersonDTO personDTO) {
        PersonEntity personEntity;
        if (personDTO.getId() != 0) {
            PersonEntity oldPersonEntity = personReponsitory.findById(personDTO.getId());
            personEntity = personConverter.toEntity(personDTO, oldPersonEntity);
        } else
            personEntity = personConverter.toEntity(personDTO);

        personReponsitory.save(personEntity);
        return personDTO;
    }

    @Override
    public void deleteById(int id) {
        personReponsitory.deleteById(id);
    }


}
