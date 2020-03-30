package com.juanlamb.hackathon.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity
public class Purchase {

    @Id
    @GeneratedValue
    private UUID id;

    @OneToOne
    private User buyer;

    @OneToOne
    private Product product;

    private int quantity;
    private double unitPrice;
    private LocalDateTime timestamp;
    private LocalDateTime expiration;
}
