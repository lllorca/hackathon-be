package com.juanlamb.hackathon.modules.purchase.dto;

import com.juanlamb.hackathon.modules.user.dto.UserDto;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class PurchaseDto {

    private UUID id;
    private UserDto buyer;
    //TODO: put productDto
    private int quantity;
    private double unitPrice;
    private LocalDateTime timestamp;
}
