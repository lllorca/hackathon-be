package com.juanlamb.hackathon.modules.purchase;

import com.juanlamb.hackathon.domain.Business;
import com.juanlamb.hackathon.exception.NotFoundException;
import com.juanlamb.hackathon.modules.business.BusinessRepository;
import com.juanlamb.hackathon.security.AuthorizationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("purchase")
public class PurchaseController {

    private final PurchaseConverter purchaseConverter;
    private final BusinessRepository businessRepository;
    private final PurchaseRepository purchaseRepository;
    private final AuthorizationService authorizationService;

    @GetMapping("/my-purchases")
    public List<PurchaseDto> myPurchases() {
        return purchaseRepository.findByBuyer(authorizationService.getLoggedInUser())
                                 .stream()
                                 .map(purchaseConverter::convert)
                                 .collect(Collectors.toList());
    }

    @GetMapping("/my-sells")
    public List<PurchaseDto> purchasesOnMyBusiness() {
        Business business = businessRepository.findByOwner(authorizationService.getLoggedInUser())
                                              .orElseThrow(NotFoundException::new);
        return purchaseRepository.findByProduct_Business(business)
                                 .stream()
                                 .map(purchaseConverter::convert)
                                 .collect(Collectors.toList());

    }

    @GetMapping("/business/{id}/count")
    public CountDto numberOfSalesOfBusiness(@PathVariable("id") long id) {
        Business business = businessRepository.findById(id).orElseThrow(NotFoundException::new);
        return new CountDto(purchaseRepository.findByProduct_Business(business).size());
    }
}
