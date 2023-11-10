package com.example.springbootbackend.repository;

import com.example.springbootbackend.models.User;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(Strcing email);

    Boolean existsByEmail(String email);


}
