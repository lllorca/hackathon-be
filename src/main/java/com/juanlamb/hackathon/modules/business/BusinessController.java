package com.juanlamb.hackathon.modules.business;

import com.juanlamb.hackathon.domain.Business;
import com.juanlamb.hackathon.domain.BusinessCategory;
import com.juanlamb.hackathon.modules.business.dto.BusinessDto;
import com.juanlamb.hackathon.modules.business.dto.CreateBusinessDto;
import com.juanlamb.hackathon.modules.product.ProductConverter;
import com.juanlamb.hackathon.modules.product.dto.ProductDto;
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
    private final ProductConverter productConverter;

    @GetMapping
    public List<BusinessDto> getAll() {
        return businessService.findAll()
                              .stream()
                              .map(businessConverter::convert)
                              .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public BusinessDto getById(@PathVariable("id") Long id) {
        return businessConverter.convert(businessService.getById(id));
    }

    @GetMapping("/{id}/product")
    public List<ProductDto> getProducts(@PathVariable("id") Long id) {
        return businessService.getBusinessProducts(id)
                              .stream()
                              .map(productConverter::convert)
                              .collect(Collectors.toList());
    }

    @GetMapping("/category/{category}")
    public List<BusinessDto> getByCategory(@PathVariable("category") BusinessCategory category) {
        return businessService.findByCategory(category)
                              .stream()
                              .map(businessConverter::convert)
                              .collect(Collectors.toList());
    }

    @GetMapping("/my-business")
    public BusinessDto getByOwner() {
        return businessConverter.convert(businessService.getLoggedInBusiness());
    }

    @PostMapping
    public BusinessDto create(@RequestBody CreateBusinessDto createBusinessDto) {
        Business businessToCreate = businessConverter.convert(createBusinessDto);
        Business newBusiness = businessService.create(businessToCreate);
        return businessConverter.convert(newBusiness);
    }
}
