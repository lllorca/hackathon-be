package com.juanlamb.hackathon.modules.purchase;

import com.juanlamb.hackathon.domain.Business;
import com.juanlamb.hackathon.domain.Product;
import com.juanlamb.hackathon.domain.Purchase;
import com.juanlamb.hackathon.exception.NotFoundException;
import com.juanlamb.hackathon.modules.business.BusinessRepository;
import com.juanlamb.hackathon.modules.product.ProductRepository;
import com.juanlamb.hackathon.security.AuthorizationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PurchaseService {

    private final ProductRepository productRepository;
    private final BusinessRepository businessRepository;
    private final PurchaseRepository purchaseRepository;
    private final AuthorizationService authorizationService;

    public List<Purchase> myPurchases() {
        return purchaseRepository.findByBuyer(authorizationService.getLoggedInUser());
    }

    public List<Purchase> mySales() {
        Business business = businessRepository.findByOwner(authorizationService.getLoggedInUser())
                                              .orElseThrow(NotFoundException::new);
        return purchaseRepository.findByProduct_Business(business);
    }

    public int numberOfSalesOfBusiness(long businessId) {
        Business business = businessRepository.findById(businessId)
                                              .orElseThrow(NotFoundException::new);
        return purchaseRepository.findByProduct_Business(business).size();
    }

    public Purchase createPurchase(Long productId, int quantity) {
        Product product = productRepository.findById(productId).orElseThrow(NotFoundException::new);
        Purchase purchase = new Purchase();
        LocalDateTime currentTime = LocalDateTime.now();

        purchase.setProduct(product);
        purchase.setQuantity(quantity);
        purchase.setUnitPrice(product.getPrice());
        purchase.setTimestamp(currentTime);
        purchase.setBuyer(authorizationService.getLoggedInUser());
        purchase.setExpiration(currentTime.plus(product.getExpirationInMonths(), ChronoUnit.MONTHS));

        return purchaseRepository.save(purchase);
    }
}
