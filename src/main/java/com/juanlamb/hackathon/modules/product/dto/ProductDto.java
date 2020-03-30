package com.juanlamb.hackathon.modules.product.dto;

import com.juanlamb.hackathon.modules.business.dto.BusinessDto;
import lombok.Data;

@Data
public class ProductDto {

    private long id;
    private BusinessDto business;
    private String name;
    private double price;
    private String paymentUrl;
    private String description;
    private int expirationInMonths;
}
