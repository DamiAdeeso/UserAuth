package com.example.springbootbackend.service;


import com.example.springbootbackend.models.User;

import java.util.Optional;

public interface UserService {

  Optional<User> findByEmail(String user);


}