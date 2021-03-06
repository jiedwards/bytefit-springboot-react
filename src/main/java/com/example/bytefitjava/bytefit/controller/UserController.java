package com.example.bytefitjava.bytefit.controller;

import com.example.bytefitjava.bytefit.entity.User;
import com.example.bytefitjava.bytefit.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserRepository userRepository;

    @GetMapping("allUsers")
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

}
