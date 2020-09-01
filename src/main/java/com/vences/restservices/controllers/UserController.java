package com.vences.restservices.controllers;

import com.vences.restservices.entities.User;
import com.vences.restservices.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    // CReate user
    @PostMapping("/users")
    public User createUser(@RequestBody User user ) {
        return userService.createUser(user);
    }

    @GetMapping("/users/{id}")
    public Optional<User> getUserById(@PathVariable("id") Long id) {
        return userService.getUserById(id);
    }

    // updateUserById
    @PutMapping("/users/{id}")
    public User updateUserById(@PathVariable("id") Long id, @RequestBody User user) {
        return userService.updateUserById(id,user);
    }

    //delete user by id
    @DeleteMapping("/users/{id}")
    public void deleteUserById(@PathVariable("id") Long id) {
        userService.deleteUserById(id);
    }

    // getUserByUsername
    @GetMapping("/users/byusername/{username}")
    public User getUserByUsername(@PathVariable("username") String username) {
        return userService.getUserByUsername(username);
    }
}
