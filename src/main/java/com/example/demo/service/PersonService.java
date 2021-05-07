package com.example.demo.service;

import com.example.demo.converter.PersonConverter;
import com.example.demo.dao.mysql.dao.PersonReponsitory;
import com.example.demo.dto.PersonDTO;
import com.example.demo.entity.mysql.PersonEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.data.domain.Pageable;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonService implements IPersonService {
    @Autowired
    private PersonReponsitory personReponsitory;

    @Autowired
    private PersonConverter personConverter;

    @Override
    public List<PersonDTO> getAll() {
        List<PersonDTO> personDTOList = new ArrayList<>();
        List<PersonEntity> personEntityList = personReponsitory.findAll();

        for (PersonEntity personEntity : personEntityList) {
            personDTOList.add(personConverter.toPersonDTO(personEntity));
        }

        return personDTOList;
    }

    @Override
    public List<PersonDTO> getAll(Pageable pageable) {
        List<PersonDTO> result = new ArrayList<>();
        List<PersonEntity> personEntityList = personReponsitory.findAll(pageable).getContent();

        for (PersonEntity personEntity : personEntityList) {
            PersonDTO personDTO = personConverter.toPersonDTO(personEntity);
            result.add(personDTO);
        }

        return result;
    }

    @Override
    public PersonDTO findById(int id) {
        PersonEntity personEntity = personReponsitory.findById(id);
        if (personEntity != null) {
            return personConverter.toPersonDTO(personEntity);
        } else
            return new PersonDTO();
    }


    @Override
    public PersonDTO save(PersonDTO personDTO) {
        PersonEntity personEntity;
        if (personDTO.getId() != 0) {
            PersonEntity oldPersonEntity = personReponsitory.findById(personDTO.getId());
            personEntity = personConverter.toEntity(personDTO, oldPersonEntity);
        } else
            personEntity = personConverter.toPersonEntity(personDTO);

        personReponsitory.save(personEntity);
        return personDTO;
    }

    @Override
    public void deleteById(int id) {
        personReponsitory.deleteById(id);
    }

    @Override
    public List<PersonDTO> findByName(String name) {
        List<PersonEntity> listPersonEntity = personReponsitory.findByName(name);
        List<PersonDTO> result = new ArrayList<>();
        for (PersonEntity personEntity : listPersonEntity) {
            PersonDTO personDTO = personConverter.toPersonDTO(personEntity);
            result.add(personDTO);
        }
        return result;
    }


}
