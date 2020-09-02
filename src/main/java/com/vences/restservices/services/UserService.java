package com.vences.restservices.services;

import com.vences.restservices.entities.User;
import com.vences.restservices.exceptions.UserExistsException;
import com.vences.restservices.exceptions.UserNotFoundException;
import com.vences.restservices.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

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
    public User createUser(User user) throws UserExistsException {
        User existingUser = userRepository.findByUsername(user.getUsername());
        if(existingUser != null ) {
            throw new UserExistsException("User already exists in repository");
        }
        return userRepository.save(user);
    }

    public Optional<User> getUserById(Long id) throws UserNotFoundException {
        Optional<User> user = userRepository.findById(id);

        if(!user.isPresent()) {
            throw new UserNotFoundException("User not found in user repository");
        }

        return user;
    }

    public User updateUserById(Long id, User user ) throws UserNotFoundException{
        Optional<User> userOptional = userRepository.findById(id);

        if(!userOptional.isPresent()) {
            throw new UserNotFoundException("User not found in user repository, provide the correct user id");
        }
        user.setId(id);
        return userRepository.save(user);

    }

    // delete user by id
    public void deleteUserById(Long id) {
        Optional<User> userOptional = userRepository.findById(id);

        if(!userOptional.isPresent()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"User not found in user repository, provide the correct user id");
        }

        userRepository.deleteById(id);
    }

    // getUserByUsername
    public User getUserByUsername(String username){
        return userRepository.findByUsername(username);
    }

}
