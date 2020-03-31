package com.juanlamb.hackathon.modules.business.dto;

import com.juanlamb.hackathon.domain.Address;
import com.juanlamb.hackathon.domain.BusinessCategory;
import com.juanlamb.hackathon.modules.product.dto.ProductDto;
import com.juanlamb.hackathon.modules.user.dto.UserDto;
import lombok.Data;

import java.util.List;

@Data
public class BusinessDto {

    private long id;
    private String name;
    private BusinessCategory category;
    private Address address;
    private UserDto owner;
    private List<ProductDto> products;
}
