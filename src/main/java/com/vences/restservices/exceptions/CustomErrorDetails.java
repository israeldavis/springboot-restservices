package com.vences.restservices.exceptions;

import lombok.*;

import java.util.Date;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
public class CustomErrorDetails {
    private Date timestamp;
    private String message;
    private String errordetails;


}
