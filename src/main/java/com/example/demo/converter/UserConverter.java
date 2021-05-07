package com.example.demo.converter;

import com.example.demo.dao.mysql.dao.RoleReponsitory;
import com.example.demo.dto.UserDTO;

import com.example.demo.entity.mysql.RoleEntity;
import com.example.demo.entity.mysql.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.security.crypto.password.PasswordEncoder;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Component
public class UserConverter {
    @Autowired
    private RoleReponsitory roleReponsitory;

    @Autowired
    private PasswordEncoder bCryptPasswordEncoder;



    public UserEntity toUserEntity(UserDTO userDTO){
        UserEntity userEntity = new UserEntity();
        userEntity.setUsername(userDTO.getUsername());
        userEntity.setPassword(bCryptPasswordEncoder.encode(userDTO.getPassword()));
        List<RoleEntity> roles = new ArrayList<>();
        RoleEntity roleEntity = roleReponsitory.findByName("User");
        roles.add(roleEntity);
        userEntity.setRoles(roles);

        return userEntity;

    }
}
