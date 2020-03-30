package com.juanlamb.hackathon.modules.product;

import com.juanlamb.hackathon.domain.Business;
import com.juanlamb.hackathon.domain.Product;
import com.juanlamb.hackathon.domain.User;
import com.juanlamb.hackathon.modules.business.BusinessRepository;
import com.juanlamb.hackathon.security.AuthorizationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class ProductService {

    private final BusinessRepository businessRepository;
    private final AuthorizationService authorizationService;
    private final ProductRepository productRepository;

    public Product addProduct(Product productToCreate) {
        User loggedUser = authorizationService.getLoggedInUser();
        Optional<Business> business = businessRepository.findByOwner(loggedUser);
        if(!business.isPresent()) {
            throw new IllegalArgumentException("User has no business");
        }
        productToCreate.setBusiness(business.get());
        return productRepository.save(productToCreate);
    }
}
