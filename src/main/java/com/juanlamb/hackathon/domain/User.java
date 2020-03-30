package com.juanlamb.hackathon.domain;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;
    private String lastName;
    private String document;

    @Column(unique = true)
    private String email;
    private String password;

    @OneToOne(mappedBy = "owner")
    private Business business;
}
