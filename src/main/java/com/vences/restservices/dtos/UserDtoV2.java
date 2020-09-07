package com.vences.restservices.dtos;

import com.vences.restservices.entities.Order;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserDtoV2 {

    private Long id;
    private String username;
    private String firstname;
    private String lastname;
    private String email;
    private String role;
    private String ssn;
    private String address;
    private List<Order> orders;
}
