package com.example.springbootbackend.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "user")
public class User {
    @Id
    @Column(name = "user_Id", length = 45)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long userid;

    @Column(name = "first_name", length = 255)
    private String firstname;


    @Column(name = "last_name", length = 255)
    private String lastname;

    @Column(name = "email", length = 255)
    private String email;


    @Column(name = "password", length = 255)
    @JsonIgnore
    private String password;


    @Column(name = "phone_number", length = 255)
    private String phonenumber;

}
