package com.example.demo.entity.mysql;


import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "role")
public class RoleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    public RoleEntity() {
    }

    @ManyToMany(mappedBy = "roles")
    List<UserEntity> users;

    public RoleEntity(String name) {
        super();
        this.name = name;
    }

}
