package com.example.week8.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.Column;

@RequiredArgsConstructor
@Data
public class UserDto {
    private String firstName;
    private String lastName;

    private String userName;

    private String password;
}

