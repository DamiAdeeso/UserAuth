package com.example.springbootbackend.dto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class UserDto {
    private Long userid;

    private String username;

    private String email;

    private String password;
}
