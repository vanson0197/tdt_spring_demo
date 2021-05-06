package com.example.demo.person.dao;

import com.example.demo.dto.PersonDTO;
import com.example.demo.entity.person.PersonEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;
import java.util.List;


@Repository
public interface PersonReponsitory extends JpaRepository<PersonEntity, Integer> {
    PersonEntity findById(int id);

}
