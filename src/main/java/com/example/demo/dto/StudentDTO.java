package com.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.validation.constraints.Size;

@Data
public class StudentDTO {
    private static final long serialVersionUID = 1L;

    @JsonProperty("id")
    private  int id;

    @JsonProperty("name")
    @Size(max = 50)
    private String name;

    @JsonProperty("age")
    private int age;

    @JsonProperty("address")
    @Size(max = 50)
    private String address;
}






