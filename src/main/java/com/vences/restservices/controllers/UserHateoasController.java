package com.vences.restservices.controllers;

import com.vences.restservices.entities.Order;
import com.vences.restservices.entities.User;
import com.vences.restservices.exceptions.UserNotFoundException;
import com.vences.restservices.repositories.UserRepository;
import com.vences.restservices.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
/*import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.ControllerLinkBuilder;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;*/
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.constraints.Min;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/hateoas/users")
@Validated
public class UserHateoasController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    /*@GetMapping
    public CollectionModel<User> getAllUsers() throws UserNotFoundException {
        List<User> users =  userService.getAllUsers();
        for (User user : users ) {
            //Selflink
            Long userid = user.getId();
            Link selflink = ControllerLinkBuilder.linkTo(this.getClass()).slash(userid).withSelfRel();
            user.add(selflink);

            //Relationship link with getAllOrders
            CollectionModel<Order> orders = WebMvcLinkBuilder.methodOn(OrderHateoasController.class)
                    .getAllOrders(userid);
            Link ordersLink = ControllerLinkBuilder.linkTo(orders).withRel("all-orders");
            user.add(ordersLink);

        }
        //Self link for getAllUsers
        Link selflinkGetAllUsers = ControllerLinkBuilder.linkTo(this.getClass()).withSelfRel();


        CollectionModel<User> finalResources = new CollectionModel<User>(users, selflinkGetAllUsers);
        return finalResources;
    }*/

    /*@GetMapping("/{id}")
    public EntityModel<User> getUserById(@PathVariable("id") @Min(1) Long id) {
        try {
            Optional<User> userOptional = userService.getUserById(id);
            User user = userOptional.get();
            Long userid = user.getId();

            Link selflink = ControllerLinkBuilder.linkTo(this.getClass()).slash(userid).withSelfRel();
            user.add(selflink);
            EntityModel<User> finalResource = new EntityModel<User>(user);
            return finalResource;

        } catch (UserNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }*/


}
