package com.juanlamb.hackathon.domain;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Business business;

    private String name;
    private double price;
    private String description;
    private int expirationInMonths;
}
