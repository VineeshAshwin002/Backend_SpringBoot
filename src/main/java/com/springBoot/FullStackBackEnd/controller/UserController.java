package com.springBoot.FullStackBackEnd.controller;

import com.springBoot.FullStackBackEnd.model.User;
import com.springBoot.FullStackBackEnd.repository.UserRepository;
import com.springBoot.FullStackBackEnd.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin("http://localhost:3000")
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/user")
    public User postUser(@RequestBody User user){
        return userService.postUser(user);
    }

    @GetMapping("/get")
    public List<User> getUser(){
        return userService.getUser();
    }

    @GetMapping("/get/{id}")
    public User getById(@PathVariable Long id){
        return userService.getById(id);
    }

    @PutMapping("/get/{id}")
    public User updateUser(@PathVariable Long id , @RequestBody User editUser){
        return userService.updateUser(id,editUser);
    }

    @DeleteMapping("/get/{id}")
    public String deleteUser(@PathVariable Long id){
         userService.deleteUser(id);
        return "Deleted " +
                id;
    }

}
