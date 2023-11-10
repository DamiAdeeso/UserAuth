package com.example.springbootbackend.response;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginResponse {
    String message;
    Boolean status;
}
