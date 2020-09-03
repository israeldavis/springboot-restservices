package com.vences.restservices.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.hateoas.RepresentationModel;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "user")
public class User extends RepresentationModel<User> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "Username is mandatory field. Please privide username")
    @Column(name="USER_NAME", length = 50, nullable = false, unique = true)
    private String username;

    @Size(min=2, message="First Name should have atleast 2 characters")
    @Column(name="FIRST_NAME", length = 50, nullable = false)
    private String firstname;

    @Column(name="LAST_NAME", length = 50, nullable = false)
    private String lastname;

    @Column(name="EMAIL_ADDRESS", length = 50, nullable = false)
    private String email;

    @Column(name="ROLE", length = 50, nullable = false)
    private String role;

    @Column(name="SSN", length = 50, nullable = false, unique = true)
    private String ssn;

    @OneToMany(mappedBy = "user")
    private List<Order> orders;

}
