package com.example.springbootbackend.service.impl;

import com.example.springbootbackend.dto.LoginDto;
import com.example.springbootbackend.models.User;
import com.example.springbootbackend.response.LoginResponse;

import java.util.Optional;

public interface UserServiceImpl  {

    Optional<User> findByEmail(String user);

}
