package com.vences.restservices.entities;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonView;
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
//@JsonIgnoreProperties({"firstname", "lastname"})---- Static Filtering @JSONIgnore
//@JsonFilter( value = "userFilter") -- Used for Mapping Jackson Value filtering section
public class User extends RepresentationModel<User> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView(Views.External.class)
    private Long id;

    @NotEmpty(message = "Username is mandatory field. Please privide username")
    @Column(name="USER_NAME", length = 50, nullable = false, unique = true)
    @JsonView(Views.External.class)
    private String username;

    @Size(min=2, message="First Name should have atleast 2 characters")
    @Column(name="FIRST_NAME", length = 50, nullable = false)
    @JsonView(Views.External.class)
    private String firstname;

    @Column(name="LAST_NAME", length = 50, nullable = false)
    @JsonView(Views.External.class)
    private String lastname;

    @Column(name="EMAIL_ADDRESS", length = 50, nullable = false)
    @JsonView(Views.External.class)
    private String email;

    @Column(name="ROLE", length = 50, nullable = false)
    @JsonView(Views.Internal.class)
    private String role;

    @Column(name="SSN", length = 50, nullable = false, unique = true)
    @JsonView(Views.Internal.class)
    //@JsonIgnore
    private String ssn;

    @OneToMany(mappedBy = "user")
    @JsonView(Views.Internal.class)
    private List<Order> orders;

}
