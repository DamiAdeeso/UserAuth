package com.example.springbootbackend.dto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class UserDto {
    private Long userid;

    private String firstname;

    private String lastname;

    private String email;

    private String password;

    private String phonenumber;

}
