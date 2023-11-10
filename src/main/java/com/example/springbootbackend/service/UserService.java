package com.example.springbootbackend.service;

import com.example.springbootbackend.dto.LoginDto;
import com.example.springbootbackend.dto.UserDto;
import com.example.springbootbackend.models.User;
import com.example.springbootbackend.repository.UserRepository;
import com.example.springbootbackend.response.LoginResponse;
import com.example.springbootbackend.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Optional;

@Service
public class UserService implements UserServiceImpl {
  @Autowired
  private final UserRepository userRepository;

  @Autowired
  private final PasswordEncoder passwordEncoder;

  public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
    this.userRepository = userRepository;
    this.passwordEncoder = passwordEncoder;
  }

// public ResponseEntity<String> login(@RequestBody LoginDto loginDto) {
//  if (userRepository.existsByEmail(loginDto.getEmail()) != null) {
//     return new ResponseEntity<>("Email is not present!", HttpStatus.BAD_REQUEST);
//   }
//   User user = new User();
//  user.getEmail(loginDto)
//
//    return new ResponseEntity<>("login successful");
//}


    public ResponseEntity<String> login(@RequestBody LoginDto loginDto){
    if (userRepository.existsByEmail(loginDto.getEmail()) != null) {
    return new ResponseEntity<>("Email is not present!", HttpStatus.BAD_REQUEST);
   }
        return new ResponseEntity<>("Logged in successfully", HttpStatus.OK);
    }


  public ResponseEntity<String> saveUser(@RequestBody UserDto userDto) {
    if (userRepository.existsByEmail(userDto.getEmail())) {
      return new ResponseEntity<>("Email is present!", HttpStatus.BAD_REQUEST);
    }

    User user = new User();
    user.setUsername(userDto.getUsername());
    user.setEmail(userDto.getEmail());
    user.setPassword(passwordEncoder.encode((userDto.getPassword())));

    userRepository.save(user);
    return new ResponseEntity<>("User registered successfully", HttpStatus.OK);
  }


  @Override
  public Optional<User> findByEmail(String user) {
    return userRepository.findByEmail(user);
  }


}