package com.example.springbootwithpostgresqldevelopment.controller;

import com.example.springbootwithpostgresqldevelopment.entities.User;
import com.example.springbootwithpostgresqldevelopment.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@RestController
@RequestMapping("/api")
public class UserController {


    @Autowired
    private UserRepo userRepo;
    @PostMapping("/save")
    public void insertUser(@RequestBody User user){

        userRepo.save(user);

    }

    @GetMapping("/getUsers")
    public List<User> findAllUser(){

        return userRepo.findAll();

    }
}
