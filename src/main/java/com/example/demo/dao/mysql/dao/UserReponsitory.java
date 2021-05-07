package com.example.demo.dao.mysql.dao;


import com.example.demo.entity.mysql.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserReponsitory extends JpaRepository<UserEntity, Long> {
    UserEntity findByUsername(String username);
}
