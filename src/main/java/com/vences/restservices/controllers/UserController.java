package com.vences.restservices.controllers;

import com.vences.restservices.entities.User;
import com.vences.restservices.exceptions.UserExistsException;
import com.vences.restservices.exceptions.UserNameNotFoundException;
import com.vences.restservices.exceptions.UserNotFoundException;
import com.vences.restservices.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.List;
import java.util.Optional;

@RestController
@Validated
@RequestMapping(value="/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    // CReate user
    @PostMapping
    public ResponseEntity<Void> createUser(@Valid @RequestBody User user, UriComponentsBuilder builder) {
        try {
            userService.createUser(user);
            HttpHeaders headers = new HttpHeaders();
            headers.setLocation(builder.path("/users/{id}").buildAndExpand(user.getId()).toUri());
            return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
        } catch (UserExistsException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public Optional<User> getUserById(@PathVariable("id") @Min(1) Long id) {
        try {
            return userService.getUserById(id);
        } catch (UserNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }

    // updateUserById
    @PutMapping("/{id}")
    public User updateUserById(@PathVariable("id") Long id, @RequestBody User user) {
        try {
            return userService.updateUserById(id,user);
        } catch (UserNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    //delete user by id
    @DeleteMapping("/{id}")
    public void deleteUserById(@PathVariable("id") Long id) {
        userService.deleteUserById(id);
    }

    // getUserByUsername
    @GetMapping("/byusername/{username}")
    public User getUserByUsername(@PathVariable("username") String username) throws UserNameNotFoundException {
        User user = userService.getUserByUsername(username);
        if(user == null ) {
            throw new UserNameNotFoundException("Username: '" + username + "' not found in User repository");
        }

        return user;
    }
}
