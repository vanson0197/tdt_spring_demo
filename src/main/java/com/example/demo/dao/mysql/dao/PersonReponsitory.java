package com.example.demo.dao.mysql.dao;

import com.example.demo.entity.mysql.PersonEntity;
import com.example.demo.entity.postgres.StudentEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.net.ContentHandler;
import java.util.List;


@Repository
public interface PersonReponsitory extends JpaRepository<PersonEntity, Integer> {
    PersonEntity findById(int id);
    List<PersonEntity> findByName(String name);

}
