package com.juanlamb.hackathon.modules.purchase;

import com.juanlamb.hackathon.domain.Purchase;
import com.juanlamb.hackathon.modules.purchase.dto.CountDto;
import com.juanlamb.hackathon.modules.purchase.dto.CreatePurchaseDto;
import com.juanlamb.hackathon.modules.purchase.dto.PurchaseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("purchase")
public class PurchaseController {

    private final PurchaseService purchaseService;
    private final PurchaseConverter purchaseConverter;


    @GetMapping("/my-purchases")
    public List<PurchaseDto> myPurchases() {
        return purchaseService.myPurchases()
                              .stream()
                              .map(purchaseConverter::convert)
                              .collect(Collectors.toList());
    }

    @GetMapping("/my-sales")
    public List<PurchaseDto> mySales() {
        return purchaseService.mySales()
                              .stream()
                              .map(purchaseConverter::convert)
                              .collect(Collectors.toList());

    }

    @GetMapping("/business/{id}/count")
    public CountDto numberOfSalesOfBusiness(@PathVariable("id") long id) {
        return new CountDto(purchaseService.numberOfSalesOfBusiness(id));
    }

    @PostMapping
    public PurchaseDto createPurchase(@RequestBody CreatePurchaseDto createPurchaseDto) {
        Purchase purchase = purchaseService.createPurchase(createPurchaseDto.getProductId(), createPurchaseDto.getQuantity());
        return purchaseConverter.convert(purchase);
    }
}
