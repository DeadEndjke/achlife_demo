package com.example.AchLife.controller;


import com.example.AchLife.entity.User;
import com.example.AchLife.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/users")
public class UserController {


    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> getUsers(){
        return this.userService.getUsers();
    }

    @PostMapping
    public void addNewUser(@RequestBody User user){
        this.userService.addNewUser(user);
    }

    @DeleteMapping(path = "{userId}")
    public void deleteUser(Long userId){
        this.userService.deleteUser(userId);
    }

    @GetMapping(path = "{userId}")
    public Optional<User> getUserById(@PathVariable Long userId){
        return this.userService.getUserById(userId);
    }
}
