package com.juanlamb.hackathon.modules.purchase;

import com.juanlamb.hackathon.modules.business.dto.BusinessDto;
import com.juanlamb.hackathon.modules.user.dto.UserDto;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class PurchaseDto {

    private UUID id;
    private UserDto buyer;
    private BusinessDto business;
    private int quantity;
    private double unitPrice;
    private LocalDateTime timestamp;
}
