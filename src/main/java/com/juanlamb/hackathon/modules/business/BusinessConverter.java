package com.juanlamb.hackathon.modules.business;

import com.juanlamb.hackathon.domain.Business;
import com.juanlamb.hackathon.modules.business.dto.BusinessDto;
import com.juanlamb.hackathon.modules.business.dto.CreateBusinessDto;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BusinessConverter {

    private final ModelMapper modelMapper;

    public Business convert(CreateBusinessDto dto) {
        return modelMapper.map(dto, Business.class);
    }

    public BusinessDto convert(Business business) {
        return modelMapper.map(business, BusinessDto.class);
    }
}
