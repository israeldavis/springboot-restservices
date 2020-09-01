package com.vences.restservices.hello;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDetails {

    private String firstname;
    private String lastname;
    private String city;
}
