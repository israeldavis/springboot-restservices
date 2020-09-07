package com.vences.restservices.controllers;

import com.vences.restservices.dtos.UserMmDto;
import com.vences.restservices.entities.User;
import com.vences.restservices.exceptions.UserNotFoundException;
import com.vences.restservices.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.Min;
import java.util.Optional;

@RestController
@RequestMapping("/modelmapper/users")
public class UserModelMapperController {

    @Autowired
    private UserService userService;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping("/{id}")
    public UserMmDto getUserById(@PathVariable("id") @Min(1) Long id) throws UserNotFoundException {

            Optional<User> userOptional = userService.getUserById(id);
            if(!userOptional.isPresent()) {
                throw new UserNotFoundException("User not found");
            }

            User user = userOptional.get();

            UserMmDto userMmDto = modelMapper.map(user, UserMmDto.class);
            return userMmDto;

    }
}
