package com.juanlamb.hackathon.modules.business;

import com.juanlamb.hackathon.domain.Business;
import com.juanlamb.hackathon.modules.business.dto.BusinessDto;
import com.juanlamb.hackathon.modules.business.dto.CreateBusinessDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("business")
public class BusinessController {

    private final BusinessService businessService;
    private final BusinessConverter businessConverter;

    @PostMapping
    public BusinessDto create(@RequestBody CreateBusinessDto createBusinessDto) {
        Business businessToCreate = businessConverter.convert(createBusinessDto);
        Business newBusiness = businessService.create(businessToCreate);
        return businessConverter.convert(newBusiness);
    }
}
