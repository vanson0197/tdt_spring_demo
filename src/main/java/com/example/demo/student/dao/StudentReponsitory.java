package com.example.demo.student.dao;

import com.example.demo.entity.student.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentReponsitory  extends JpaRepository<StudentEntity, Integer> {

}
