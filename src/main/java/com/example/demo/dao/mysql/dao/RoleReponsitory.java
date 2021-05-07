package com.example.demo.dao.mysql.dao;


import com.example.demo.entity.mysql.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleReponsitory extends JpaRepository<RoleEntity, Long> {
    RoleEntity findByName(String name);
}
