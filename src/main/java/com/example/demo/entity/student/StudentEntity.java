package com.example.demo.entity.student;
import lombok.Data;
import javax.persistence.*;

@Data
@Entity
@Table(name = "student")
public class StudentEntity {
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
