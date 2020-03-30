package com.juanlamb.hackathon.modules.business;

import com.juanlamb.hackathon.domain.Business;
import com.juanlamb.hackathon.domain.BusinessCategory;
import com.juanlamb.hackathon.modules.business.dto.BusinessDto;
import com.juanlamb.hackathon.modules.business.dto.CreateBusinessDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("business")
public class BusinessController {

    private final BusinessService businessService;
    private final BusinessConverter businessConverter;

    @GetMapping("/{id}")
    public BusinessDto getById(@PathVariable("id") Long id) {
        return businessConverter.convert(businessService.getById(id));
    }

    @GetMapping("/category/{category}")
    public List<BusinessDto> getByCategory(@PathVariable("category") BusinessCategory category) {
        return businessService.findByCategory(category)
                              .stream()
                              .map(businessConverter::convert)
                              .collect(Collectors.toList());
    }

    @PostMapping
    public BusinessDto create(@RequestBody CreateBusinessDto createBusinessDto) {
        Business businessToCreate = businessConverter.convert(createBusinessDto);
        Business newBusiness = businessService.create(businessToCreate);
        return businessConverter.convert(newBusiness);
    }
}
