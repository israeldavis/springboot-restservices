package com.vences.restservices.services;

import com.vences.restservices.entities.User;
import com.vences.restservices.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    //Create user method
    public User createUser(User user) {
        return userRepository.save(user);
    }

    public Optional<User> getUserById(Long id) {
        return   userRepository.findById(id);
    }

    public User updateUserById(Long id, User user ) {
        user.setId(id);
        return userRepository.save(user);
    }

    // delete user by id
    public void deleteUserById(Long id) {
        if(userRepository.findById(id).isPresent()) {
            userRepository.deleteById(id);
        }
    }

    // getUserByUsername
    public User getUserByUsername(String username){
        return userRepository.findByUsername(username);
    }

}
