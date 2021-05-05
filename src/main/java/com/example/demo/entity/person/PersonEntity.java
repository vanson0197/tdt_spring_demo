package com.example.demo.entity.person;

import lombok.*;


import javax.persistence.*;

@Entity
@Data
@Table(name = "person")
public class PersonEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name", length = 50)
    private String name;

    @Column(name = "age")
    private int age;

    @Column(name = "address", length = 50)
    private String address;

}
