package com.juanlamb.hackathon.modules.product;

import com.juanlamb.hackathon.domain.Product;
import com.juanlamb.hackathon.modules.product.dto.CreateProductDto;
import com.juanlamb.hackathon.modules.product.dto.ProductDto;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ProductConverter {

    private final ModelMapper modelMapper;

    public Product convert(CreateProductDto productDto) { return modelMapper.map(productDto, Product.class); }

    public ProductDto convert(Product product) {
        return modelMapper.map(product, ProductDto.class);
    }
}
