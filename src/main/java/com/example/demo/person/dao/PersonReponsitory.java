package com.example.demo.person.dao;

import com.example.demo.entity.person.PersonEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface PersonReponsitory extends JpaRepository<PersonEntity, Integer> {

}
