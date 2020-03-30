package com.juanlamb.hackathon.modules.user.dto;

import lombok.Data;

@Data
public class RegisterDto {

    private String name;
    private String lastName;
    private String document;
    private String email;
    private String password;
}
