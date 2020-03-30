package com.juanlamb.hackathon.domain;

import lombok.Data;

import javax.persistence.Embeddable;

@Data
@Embeddable
public class Address {

    private String street;
    private String number;
    private String floor;
    private String city;
}
