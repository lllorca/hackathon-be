package com.juanlamb.hackathon.modules.purchase.dto;

import lombok.Data;

@Data
public class CreatePurchaseDto {

    private int quantity;
    private long productId;
}
