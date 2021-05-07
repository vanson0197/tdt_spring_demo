package com.example.demo.user;

import com.example.demo.converter.UserConverter;
import com.example.demo.dao.mysql.dao.UserReponsitory;
import com.example.demo.dto.UserDTO;
import com.example.demo.entity.mysql.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService implements UserDetailsService {
    @Autowired
    private UserReponsitory userReponsitory;

    @Autowired
    private UserConverter userConverter;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity userEntity = userReponsitory.findByUsername(username);
        if(userEntity == null){
            throw new UsernameNotFoundException("Invalid username or password.");
        }
        return new CustomUserDetails(userEntity);
    }

    @Transactional
    public UserDetails loadUserById(Long id) {
        UserEntity userEntity = userReponsitory.findById(id).orElseThrow(
                () -> new UsernameNotFoundException("User not found with id : " + id)
        );

        return new CustomUserDetails(userEntity);
    }

    public void saveUser(UserDTO userDTO){
        UserEntity userEntity= new UserEntity();
        userEntity = userConverter.toUserEntity(userDTO);
        userReponsitory.save(userEntity);

    }
}
