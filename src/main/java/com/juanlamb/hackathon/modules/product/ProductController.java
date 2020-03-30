package com.juanlamb.hackathon.modules.product;

import com.juanlamb.hackathon.domain.Business;
import com.juanlamb.hackathon.domain.Product;
import com.juanlamb.hackathon.domain.User;
import com.juanlamb.hackathon.exception.NotFoundException;
import com.juanlamb.hackathon.modules.business.BusinessRepository;
import com.juanlamb.hackathon.modules.product.dto.CreateProductDto;
import com.juanlamb.hackathon.modules.product.dto.ProductDto;
import com.juanlamb.hackathon.modules.user.dto.UserDto;
import com.juanlamb.hackathon.security.AuthorizationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductConverter productConverter;
    private final ProductService productService;

    @PostMapping
    public ProductDto newProduct(@Valid @RequestBody CreateProductDto createProductDto) {
        Product productToCreate = productConverter.convert(createProductDto);
        Product newProduct = productService.addProduct(productToCreate);
        return productConverter.convert(newProduct);
    }
}
