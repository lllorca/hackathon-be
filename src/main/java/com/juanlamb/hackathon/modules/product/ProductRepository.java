package com.juanlamb.hackathon.modules.product;

import com.juanlamb.hackathon.domain.Business;
import com.juanlamb.hackathon.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findAllByBusiness(Business business);
}
