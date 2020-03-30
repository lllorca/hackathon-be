package com.juanlamb.hackathon.modules.product.dto;

import lombok.Data;

@Data
public class CreateProductDto {

    private String name;
    private double price;
    private String paymentUrl;
    private String description;
    private int expirationInMonths;
}
