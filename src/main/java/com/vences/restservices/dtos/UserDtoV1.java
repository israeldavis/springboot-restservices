package com.vences.restservices.dtos;

import com.fasterxml.jackson.annotation.JsonView;
import com.vences.restservices.entities.Order;
import com.vences.restservices.entities.Views;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserDtoV1 {

    private Long id;
    private String username;
    private String firstname;
    private String lastname;
    private String email;
    private String role;
    private String ssn;
    private List<Order> orders;
}
