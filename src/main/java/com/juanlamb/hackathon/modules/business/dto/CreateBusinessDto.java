package com.juanlamb.hackathon.modules.business.dto;

import com.juanlamb.hackathon.domain.Address;
import com.juanlamb.hackathon.domain.BusinessCategory;
import lombok.Data;

@Data
public class CreateBusinessDto {

    private String name;
    private BusinessCategory category;
    private Address address;

}
