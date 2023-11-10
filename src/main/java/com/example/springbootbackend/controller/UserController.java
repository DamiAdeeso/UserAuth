package com.example.springbootbackend.controller;

import com.example.springbootbackend.dto.LoginDto;
import com.example.springbootbackend.dto.UserDto;
import com.example.springbootbackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("api/v1/accounts")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/login")
    public ResponseEntity<String> loginUser(@RequestBody LoginDto loginDto) throws UsernameNotFoundException {
        return userService.login(loginDto);
    }

    @PostMapping("/register")
    public ResponseEntity<String> saveUser(@RequestBody UserDto userDto){
        return userService.saveUser(userDto);
    }
}
