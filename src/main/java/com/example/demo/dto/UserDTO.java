package com.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.validation.constraints.Size;

@Data
public class UserDTO {
    @JsonProperty("id")
    private Long id;

    @JsonProperty("username")
    @Size(max = 255)
    private String username;

    @JsonProperty("password")
    @Size(max = 255)
    private String password;

}
