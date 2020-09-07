package com.vences.restservices.dtos;

import com.vences.restservices.entities.Order;
import lombok.Data;

import java.util.List;

@Data
public class UserMmDto {

    private Long id;
    private String username;
    private String firstname;
    private List<Order> orders;

}
