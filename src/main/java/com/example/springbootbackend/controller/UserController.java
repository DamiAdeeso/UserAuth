package com.example.springbootbackend.controller;

import com.example.springbootbackend.dto.LoginDto;
import com.example.springbootbackend.dto.UserDto;
import com.example.springbootbackend.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("api/v1/accounts")
public class UserController {

    private UserServiceImpl userServiceImpl;

    @Autowired
    public UserController(UserServiceImpl userServiceImpl) {
        this.userServiceImpl = userServiceImpl;
    }

    @PostMapping("/login")
    public ResponseEntity<String> loginUser(@RequestBody LoginDto loginDto) throws UsernameNotFoundException {
        return userServiceImpl.login(loginDto);
    }

    @PostMapping("/register")
    public ResponseEntity<String> saveUser(@RequestBody UserDto userDto){

        System.out.println(userDto);
        return userServiceImpl.saveUser(userDto);
    }
}
