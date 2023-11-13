package com.example.springbootbackend.service.impl;

import com.example.springbootbackend.dto.LoginDto;
import com.example.springbootbackend.dto.UserDto;
import com.example.springbootbackend.mail.EmailService;
import com.example.springbootbackend.models.User;
import com.example.springbootbackend.repository.UserRepository;
import com.example.springbootbackend.service.UserService;
import org.passay.CharacterRule;
import org.passay.EnglishCharacterData;
import org.passay.PasswordGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private final UserRepository userRepository;

    private final EmailService emailService;
    @Autowired
    private final PasswordEncoder passwordEncoder;


    public UserServiceImpl(UserRepository userRepository, EmailService emailService, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.emailService = emailService;
        this.passwordEncoder = passwordEncoder;
    }



    public ResponseEntity<?> login(@RequestBody LoginDto loginDto){
        if (userRepository.existsByEmail(loginDto.getEmail())) {
            Optional<User> user = userRepository.findByEmail(loginDto.getEmail());
            if(passwordEncoder.matches(loginDto.getPassword(),user.get().getPassword())){
                return new ResponseEntity<>(user, HttpStatus.OK);
            }

        }
        return new ResponseEntity<>("Incorrect Email or Password", HttpStatus.OK);
    }


    public ResponseEntity<String> saveUser(@RequestBody UserDto userDto) {
        if (userRepository.existsByEmail(userDto.getEmail())) {
            return new ResponseEntity<>("Email is present!", HttpStatus.BAD_REQUEST);
        }

        User user = new User();
        user.setFirstname(userDto.getFirstname());
        user.setLastname(userDto.getLastname());
        user.setPhonenumber(userDto.getPhonenumber());
        user.setEmail(userDto.getEmail());
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));

        userRepository.save(user);
//        emailService.sendPasswordMail(user.getEmail(),user.getUsername(),pass);
        return new ResponseEntity<>("User registered and mail sent successfully", HttpStatus.OK);
    }


    @Override
    public Optional<User> findByEmail(String user) {
        return userRepository.findByEmail(user);
    }


}
