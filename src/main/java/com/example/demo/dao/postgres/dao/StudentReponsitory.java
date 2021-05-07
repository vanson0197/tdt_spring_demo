package com.example.demo.dao.postgres.dao;

import com.example.demo.entity.postgres.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentReponsitory  extends JpaRepository<StudentEntity, Integer> {

}
