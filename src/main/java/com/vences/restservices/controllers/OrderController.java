package com.vences.restservices.controllers;

import com.vences.restservices.entities.Order;
import com.vences.restservices.entities.User;
import com.vences.restservices.exceptions.UserNotFoundException;
import com.vences.restservices.repositories.OrderRepository;
import com.vences.restservices.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/users")
public class OrderController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OrderRepository orderRepository;

    @GetMapping("/{userid}/orders")
    public List<Order> getAllOrders(@PathVariable Long userid) throws UserNotFoundException {
        Optional<User> userOptional = userRepository.findById(userid);
        if(!userOptional.isPresent())
            throw new UserNotFoundException("User Not Found");

        return userOptional.get().getOrders();
    }

    @PostMapping("{userid}/orders")
    public Order createOrder (@PathVariable Long userid, @RequestBody Order order) throws UserNotFoundException{
        Optional<User> userOptional = userRepository.findById(userid);
        if(!userOptional.isPresent())
            throw new UserNotFoundException("User Not Found");

        User user = userOptional.get();
        order.setUser(user);
        return orderRepository.save(order);
    }

    @GetMapping("/{userid}/orders/{orderid}")
    public Order getOrderByOrderId(@PathVariable Long userid, @PathVariable Long orderid ) throws UserNotFoundException {
        Optional<User> userOptional = userRepository.findById(userid);
        if(!userOptional.isPresent())
            throw new UserNotFoundException("User Not Found");

        User user = userOptional.get();
        List<Order> orders = user.getOrders();
        Order orderFound = null;
        for (Order ord : orders) {
            if(ord.getOrderId().longValue() == orderid.longValue()) {
                orderFound = ord;
                break;
            }
        }
        return orderFound;
    }
}
